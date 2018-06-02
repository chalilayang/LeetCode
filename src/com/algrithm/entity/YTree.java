package com.algrithm.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class YTree {

    public static final int PRE_TRAVERSE = -1;
    public static final int MID_TRAVERSE = 0;
    public static final int BAC_TRAVERSE = 1;

    public static class Item {
        int data;
        int count;
        Item leftChild;
        Item rightChild;

        public Item(int data) {
            this.data = data;
            this.count = 0;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getData() {
            return data;
        }

        public Item getLeftChild() {
            return leftChild;
        }

        public Item getRightChild() {
            return rightChild;
        }

        public int getCount() {
            return count;
        }
        
        public void increaseCount() {
            this.count ++;
        }

    }

    public static YTree newInstance() {
        return new YTree();
    }

    private List<Item> nodeList = null;

    public void createBinTree(int[] data) {
        if (nodeList == null) {
            nodeList = new LinkedList<Item>();
        } else {
            nodeList.clear();
        }

        for (int nodeIndex = 0, count = data.length; nodeIndex < count; nodeIndex++) {
            nodeList.add(new Item(data[nodeIndex]));
        }
        for (int parentIndex = 0; parentIndex < data.length / 2 - 1; parentIndex++) {
            nodeList.get(parentIndex).leftChild = nodeList
                    .get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).rightChild = nodeList
                    .get(parentIndex * 2 + 2);
        }
        int lastParentIndex = data.length / 2 - 1;
        nodeList.get(lastParentIndex).leftChild = nodeList
                .get(lastParentIndex * 2 + 1);
        if (data.length % 2 == 1) {
            nodeList.get(lastParentIndex).rightChild = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
        mRoot = nodeList.get(0);
    }

    public Item mRoot;

    public int[] getTreeList() {
        if (nodeList != null) {
            int count = nodeList.size();
            int[] data = new int[count];
            for (int index = 0; index < count; index++) {
                data[index] = nodeList.get(index).data;
            }
            return data;
        } else {
            return null;
        }
    }

    public void printTree(int type) {
        switch (type) {
            case PRE_TRAVERSE:
                printTreesPre(mRoot);
                break;
            case MID_TRAVERSE:
                printTreesMid(mRoot);
                break;
            case BAC_TRAVERSE:
                printTreesBac(mRoot);
                break;

            default:
                break;
        }
    }

    /**
     * 递归前向遍历打印
     */
    public void printTreesPre(Item parent) {
        if (parent != null) {
            visit(parent);
            printTreesPre(parent.leftChild);
            printTreesPre(parent.rightChild);
        }
    }

    /**
     * 非递归前向遍历
     */
    public List<Item> getPreOrderList() {
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<Item>();
        Item p = mRoot;
        if (p != null) {
            stack.push(p);
            while (!stack.empty()) {
                p = stack.pop();
                result.add(p);
                if (p.rightChild != null)
                    stack.push(p.rightChild);
                if (p.leftChild != null)
                    stack.push(p.leftChild);
            }
        }
        return result;
    }

    /**
     * 递归中序遍历打印
     */
    public void printTreesMid(Item parent) {
        if (parent != null) {
            printTreesMid(parent.leftChild);
            visit(parent);
            printTreesMid(parent.rightChild);
        }
    }

    /**
     * 非递归中序遍历
     * 
     * @param p
     * @return
     */
    public List<Item> getMidOrderList() {
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<Item>();
        Item p = mRoot;
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
     * 递归后序遍历打印
     */
    public void printTreesBac(Item parent) {
        if (parent != null) {
            printTreesBac(parent.leftChild);
            printTreesBac(parent.rightChild);
            visit(parent);
        }
    }
    
    /**
     * 非递归后序遍历
     * 
     * @param p
     * @return
     */
    public List<Item> getBacOrderList() {
        Stack<Item> stack = new Stack<Item>();
        ArrayList<Item> result = new ArrayList<>();
        Item p = mRoot;
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

    private void visit(Item data) {
        System.out.print(" ");
        System.out.print(data.data);
    }

    /**
     * 前序遍历序列和中序遍历序列恢复二叉树序列
     * 
     * @param preOrderList
     * @param midOrderList
     * @return
     */
    public List<Integer> mergeTree(List<Item> preOrderList, List<Item> midOrderList) {
        Item root = getTree(
                preOrderList,
                midOrderList,
                0,
                preOrderList.size() - 1,
                0, midOrderList.size() - 1);
        Queue<Item> stack = new LinkedBlockingQueue<>();
        LinkedList<Integer> result = new LinkedList<>();
        Item p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                result.add(p.data);
                if (p.leftChild != null) {
                    stack.offer(p.leftChild);
                }
                if (p.rightChild != null) {
                    stack.offer(p.rightChild);
                }
            }
            p = stack.poll();
        }
        return result;
    }

    public Item getTree(List<Item> preOrderList, List<Item> midOrderList, int preStart, int preEnd, int midStart,
            int midEnd)
    {
        if (preStart <= preEnd && midStart <= midEnd)
        {
//            System.out.println("preStart  " + preStart + "  preEnd " + preEnd + " midStart " + midStart + " midEnd " + midEnd);
            Item rev = new Item(preOrderList.get(preStart).data);
            int mid = find(midOrderList, midStart, midEnd, rev.data);
//            System.out.print("mid  " + mid);
            int span = mid - midStart;
            rev.leftChild = getTree(preOrderList, midOrderList, preStart + 1, preStart + 1 + span - 1, midStart, midStart
                    + span - 1);
            
            rev.rightChild = getTree(preOrderList, midOrderList, preStart + 1 + span, preEnd, midStart + span + 1,
                    midEnd);
            return rev;
        }
        return null;
    }

    private int find(List<Item> list, int start, int end, int obj) {
        if (list == null) {
            return -1;
        }
        int count = list.size();
        if (start < 0 || end >= count) {
            return -1;
        }
        int hasFound = -1;
        for (int index = 0; index < count; index++) {
            if (obj == list.get(index).data) {
                hasFound = index;
                break;
            }
        }
        return hasFound;
    }
    
    /**
     * 创建二叉查找树
     * @param data
     * @return 返回根节点
     */
    public Item createBinearySearchTree(int[] data) {
        if (data == null || data.length <= 0) {
            return null;
        }
        Item root = new Item(data[0]);
        for (int index = 1, count = data.length; index < count; index ++) {
            Item node = root;            
            while(node.getData() != data[index]) {
                if (node.getData() > data[index]) {
                    if (node.leftChild == null) {
                        Item item = new Item(data[index]);
                        node.leftChild = item;
                        break;
                    } else {
                        node = node.leftChild;
                        continue;
                    }
                } else {
                    if (node.rightChild == null) {
                        Item item = new Item(data[index]);
                        node.rightChild = item;
                        break;
                    } else {
                        node = node.rightChild;
                        continue;
                    }
                }
            }
            if (node.getData() == data[index]) {
                node.increaseCount();
            }
        }
        return root;
    }
    
//    public Item createListFromSearchTree(Item root) {
//        if (root != null) {
//            Stack<Item> 
//        }
//    }
    
    private static int compare(int ori, int obj) {
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
