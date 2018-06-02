package com.algrithm.main;

import com.algrithm.utils.DataGenerator;

public class AriTestOne {

    /**
     * TODO
     * @author chalilayang
     * @param args
     * @date 2016-9-7
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        final int value = 5;
        System.out.print(getCount(data, value));
    }
    
    /**
     * TODO 寻找有序数组中两两相加等于指定值的组合
     * @author chalilayang
     * @param data 有序数组
     * @param mValue 指定值
     * @date 2016-9-7
     */
    public static int getCount(int[] data, int mValue) {
        if (data == null || data.length <= 1) {
            return 0;
        }
        int count = 0;
        int indexBegin = 0, indexEnd = data.length-1;
        int tmpValue = 0;
        while(indexBegin < indexEnd) {
            tmpValue = data[indexBegin] + data[indexEnd];
            switch (compare(tmpValue, mValue)) {
                case 1:
                    indexEnd--;
                    break;
                case -1:
                    indexBegin++;
                    break;
                case 0:
                    count++;
                    System.out.print(data[indexBegin] + "\t" + data[indexEnd] + "\r\n");
                    indexEnd--;
                    indexBegin++;
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    private static int compare(int ori, int obj) {
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
