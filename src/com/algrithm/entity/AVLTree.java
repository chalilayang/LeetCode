package com.algrithm.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.algrithm.entity.YTree.Item;

public class AVLTree {

    private Item root = null;
    public static class Item {
        int element;  
        int height;  
        Item leftChild;  
        Item rightChild;
    }
    
    public static AVLTree newInstance() {
        return new AVLTree();
    }
    
    public AVLTree() {
        
    }
    
    public static void main(String[] args) {
        AVLTree tree = AVLTree.newInstance();
        for (int index = 0; index < 20; index ++) {
            tree.insert(index);
        }
        List<Item> result = tree.getMidOrderList();
        System.out.print("\n中序遍历：");
        for (Item item : result) {
            System.out.print(item.element + "  ");
        }
        result = tree.getPreList();
        System.out.print("\n前序遍历：");
        for (Item item : result) {
            System.out.print(item.element + "  ");
        }
        System.out.print("\n最大值：");
        System.out.print(tree.searchMax().element);
        System.out.print("\n最小值：");
        System.out.print(tree.searchMin().element);
    }
    
    
    public void insert(int value) {
        this.root = this.insert(value, this.root);
    }
    
    public Item search(int value) {
        return search(value, this.root);
    }
    
    public Item searchMin() {
        return searchMin(this.root);
    }
    
    public Item searchMax() {
        return searchMax(this.root);
    }
    
    /**
     * 非递归中序遍历
     * 
     * @param p
     * @return
     */
    public List<Item> getMidOrderList() {
        if (root == null) {
            return null;
        }
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<Item>();
        Item p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                p = p.leftChild;
            }
            if (stack.size() > 0) {
                p = stack.pop();
                result.add(p);
                p = p.rightChild;
            }
        }
        return result;
    }
    
    /**
     * 非递归后序遍历
     * 
     * @param p
     * @return
     */
    public List<Item> getBacOrderList() {
        if (root == null) {
            return null;
        }
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<Item>();
        Item p = root;
        while (p != null || stack.size() > 0) {
            while (p != null) {
                stack.push(p);
                if (p.rightChild != null) {
                    stack.push(p.rightChild);
                }
                p = p.leftChild;
            }
            p = stack.pop();
            result.add(p);
            p = stack.pop();
        }
        return result;
    }
    
    public List<Item> getPreList() {
        if (root == null) {
            return null;
        }
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<Item>();
        Item p = root;
        if (p != null) {
            stack.push(p);
            while (!stack.empty()) {
                p = stack.pop();
                result.add(p);
                if (p.rightChild != null) {
                    stack.push(p.rightChild);
                }
                if (p.leftChild != null) {
                    stack.push(p.leftChild);
                }
            }
        }
        return result;
    }
    
    private Item search(int value, Item root) {
        if (root == null) {
            return null;
        } else if (value < root.element) {
            return search(value, root.leftChild);
        } else if (value > root.element) {
            return search(value, root.rightChild);
        } else if (value == root.element) {
            return root;
        } else {
            return null;
        }
    }
    
    private Item searchMin(Item root) {
        if (root == null) {
            return null;
        } else if (root.leftChild != null) {
            return searchMin(root.leftChild);
        } else {
            return root;
        }
    }
    
    private Item searchMax(Item root) {
        if (root == null) {
            return null;
        } else if (root.rightChild != null) {
            return searchMax(root.rightChild);
        } else {
            return root;
        }
    }
    
    private Item insert(int value, Item root) {
        if (root == null) {
            root = new Item();
            root.element = value;
            root.height = 0;
            root.leftChild = null;
            root.rightChild = null;
        } else if (root.element > value) {
            root.leftChild = insert(value, root.leftChild);
            if (height(root.leftChild) - height(root.rightChild) == 2) {
                if (value < root.leftChild.element) {
                    root = singleRotateWithLeft(root);
                } else {
                    root = doubleRotateWithLeft(root);
                }
            }
        } else if (root.element < value) {
            root.rightChild = insert(value, root.rightChild);
            if (height(root.rightChild) - height(root.leftChild) == 2) {
                if (value > root.rightChild.element) {
                    root = singleRotateWithRight(root);
                } else {
                    root = doubleRotateWithRight(root);
                }
            }
        }
        root.height = max(height(root.leftChild), height(root.rightChild)) + 1;       
        return root;
    }
    
    /**
     * TODO  左旋
     * @author chalilayang
     * @param K2
     * @return
     * @date 2016-10-27
     */
    private Item singleRotateWithLeft(Item k2) {
        if (null == k2) {
            return null;
        }
        Item k1 = k2.leftChild;
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;
        
        k1.height = max(height(k1.leftChild), height(k1.rightChild)) + 1;
        k2.height = max(height(k2.leftChild), height(k2.rightChild)) + 1;
        return k1;
    }
    
    /**
     * TODO  右旋
     * @author chalilayang
     * @param K2
     * @return
     * @date 2016-10-27
     */
    private Item singleRotateWithRight(Item k2) {
        if (null == k2) {
            return null;
        }
        Item k1 = k2.rightChild;
        k2.rightChild = k1.leftChild;
        k1.leftChild = k2;
        
        k1.height = max(height(k1.leftChild), height(k1.rightChild)) + 1;
        k2.height = max(height(k2.leftChild), height(k2.rightChild)) + 1;
        return k1;
    }
    

    private Item doubleRotateWithLeft(Item k3) {
        k3.leftChild = singleRotateWithRight(k3.leftChild);  
        return singleRotateWithLeft(k3);
    }
    
    private Item doubleRotateWithRight(Item k3) {
        k3.rightChild = singleRotateWithLeft(k3.rightChild);  
        return singleRotateWithRight(k3);
    }
    
    private int height(Item item) {
        if (null == item) {
            return -1;
        }
        return item.height;
    }
    
    private int max(int a, int b) {
        return Math.max(a, b);
    }
}
