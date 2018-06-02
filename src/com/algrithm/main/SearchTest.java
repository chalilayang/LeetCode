package com.algrithm.main;

import com.algrithm.entity.YTree;
import com.algrithm.search.BinearySearch;
import com.algrithm.search.BinearySearch.Result;
import com.algrithm.sort.QuickSort;
import com.algrithm.utils.DataGenerator;

public class SearchTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] datas = DataGenerator.generateRandomDatas(100000);
//        QuickSort.sort(datas);
//        Result result = BinearySearch.search(datas, datas[7]);
//        result.print();
//        
//        datas = DataGenerator.generateRandomDatas(5);
//        YTree mTree = new YTree();
//        mTree.createBinearySearchTree(datas);
        int i = 10;
        int j = 100;
        swap(i, j);
        System.out.println("i = " + i + " j = " + j);
    }

    public static void swap(int i, int j) {
        int tmp = i;
        i = j;
        j = tmp;
    }
}
