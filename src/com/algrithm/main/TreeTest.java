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
        System.out.print("��������:");
        DataGenerator.printDatas(datas);
        YTree mTree = YTree.newInstance();
        mTree.createBinTree(datas);
        System.out.print("ǰ���������:");
        mTree.printTree(YTree.PRE_TRAVERSE);
        System.out.print("\n");
        System.out.print("�����������:");
        mTree.printTree(YTree.MID_TRAVERSE);
        System.out.print("\n");
        System.out.print("�����������:");
        mTree.printTree(YTree.BAC_TRAVERSE);
        System.out.print("\n");
        
//        System.out.print("�ǵݹ�ǰ���������:");
        List<Item> list1 = mTree.getPreOrderList();
//        System.out.println(list1.toString());
        
//        System.out.print("�ǵݹ������������:");
        List<Item> list2 = mTree.getMidOrderList();
//        System.out.println(list2.toString());
        
        List<Integer> list3 = mTree.mergeTree(list1, list2);
//        System.out.println(list3.toString());
//        int[] result = mTree.getTreeList();
//        System.out.print("����������:");
//        DataGenerator.printDatas(result);
        
        System.out.println(mTree.getBacOrderList().toString());
    }

}
