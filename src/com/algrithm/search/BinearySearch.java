package com.algrithm.search;

public class BinearySearch {
    public static int CountCompare = 0;
    public static int CountSwap = 0;

    public static class Result {
        public boolean hasFound = false;
        public int index = 0;
        public long time = 0;
        
        public void print() {
            if (hasFound) {
                System.out.print("已找到！" + "  index = " + index + "  耗时   " + time + "纳秒");
            } else {
                System.out.print("未找到！" + "  耗时   " + time + "纳秒");
            }
        }
    }
    public static Result search(int[] data, int objectValue) {
        CountCompare = 0;
        CountSwap = 0;
        long time = System.nanoTime();

        Result result = new Result();
        if (data == null) {
            return result;
        }
        int low = 0;
        int high = data.length - 1;
        boolean hasFound = false;
        int index = 0;
        while (low < high) {
            int mid = (int) (low * 1.0 + (high - low) * 0.5);
            int mtmp = compare(data[mid], objectValue);
            if (mtmp == 0) {
                hasFound = true;
                index = mid;
                break;
            }
            switch (mtmp) {
                case 1:
                    high = mid - 1;
                    break;
                case -1:
                    low = mid + 1;
                    break;
                default:
                    break;
            }
        }
        if (hasFound) {
            result.hasFound = true;
            result.index = index;
        } else if (compare(data[low], objectValue) == 0) {
            result.hasFound = true;
            result.index = low;
        }
        result.time = System.nanoTime() - time;
        return result;
    }

    private static int compare(int ori, int obj) {
        CountCompare++;
        return ori > obj ? 1 : (ori == obj ? 0 : -1);
    }
}
