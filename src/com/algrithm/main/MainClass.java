package com.algrithm.main;

import com.algrithm.sort.InsertSort;
import com.algrithm.sort.PopSort;
import com.algrithm.sort.QuickSort;
import com.algrithm.sort.SelectionSort;
import com.algrithm.utils.DataGenerator;

public class MainClass {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] datas = DataGenerator.generateRandomDatas(10);
        
        int[] datas1 = datas.clone();
        int[] datas2 = datas.clone();
        int[] datas3 = datas.clone();
        int[] datas4 = datas.clone();
        int[] datas5 = datas.clone();
        
        DataGenerator.printDatas(datas);
        System.out.print("\n\n");
        
        
        System.out.println("ѡ������");
        long time = SelectionSort.sort(datas1);
        DataGenerator.printDatas(datas1);
        System.out.print("\n");
        System.out.println("�Ƚϴ��� :" + SelectionSort.CountCompare);
        System.out.println("�������� :" + SelectionSort.CountSwap);
        System.out.println("����ʱ�� :" + time + "����" );
        
        System.out.println("ð������");
        time = PopSort.sort(datas2);
        DataGenerator.printDatas(datas2);
        System.out.print("\n");
        System.out.println("�Ƚϴ��� :" + PopSort.CountCompare);
        System.out.println("�������� :" + PopSort.CountSwap);
        System.out.println("����ʱ�� :" + time + "����" );
        
        System.out.println("��������");
        time = InsertSort.sort(datas3);
        DataGenerator.printDatas(datas3);
        System.out.print("\n");
        System.out.println("�Ƚϴ��� :" + InsertSort.CountCompare);
        System.out.println("�������� :" + InsertSort.CountSwap);
        System.out.println("����ʱ�� :" + time + "����" );
        
        System.out.println("��������");
        time = QuickSort.sort(datas4);
        DataGenerator.printDatas(datas4);
        System.out.print("\n");
        System.out.println("�Ƚϴ��� :" + QuickSort.CountCompare);
        System.out.println("�������� :" + QuickSort.CountSwap);
        System.out.println("����ʱ�� :" + time + "����" );
        
        System.out.println("�ǵݹ��������");
        time = QuickSort.sortNotRecursive(datas5);
        DataGenerator.printDatas(datas5);
        System.out.print("\n");
        System.out.println("�Ƚϴ��� :" + QuickSort.CountCompare);
        System.out.println("�������� :" + QuickSort.CountSwap);
        System.out.println("����ʱ�� :" + time + "����" );
        
        System.out.print("\n\n");
    }
}
