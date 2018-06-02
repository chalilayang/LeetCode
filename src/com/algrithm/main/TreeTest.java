package com.algrithm.main;

import java.util.List;

import com.algrithm.entity.YTree;
import com.algrithm.entity.YTree.Item;
import com.algrithm.utils.DataGenerator;

public class TreeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] datas = DataGenerator.generateAscDatas(19);
        System.out.print("测试数组:");
        DataGenerator.printDatas(datas);
        YTree mTree = YTree.newInstance();
        mTree.createBinTree(datas);
        System.out.print("前向遍历数组:");
        mTree.printTree(YTree.PRE_TRAVERSE);
        System.out.print("\n");
        System.out.print("中序遍历数组:");
        mTree.printTree(YTree.MID_TRAVERSE);
        System.out.print("\n");
        System.out.print("后序遍历数组:");
        mTree.printTree(YTree.BAC_TRAVERSE);
        System.out.print("\n");
        
//        System.out.print("非递归前向遍历数组:");
        List<Item> list1 = mTree.getPreOrderList();
//        System.out.println(list1.toString());
        
//        System.out.print("非递归中序遍历数组:");
        List<Item> list2 = mTree.getMidOrderList();
//        System.out.println(list2.toString());
        
        List<Integer> list3 = mTree.mergeTree(list1, list2);
//        System.out.println(list3.toString());
//        int[] result = mTree.getTreeList();
//        System.out.print("二叉树数组:");
//        DataGenerator.printDatas(result);
        
        System.out.println(mTree.getBacOrderList().toString());
    }

}
