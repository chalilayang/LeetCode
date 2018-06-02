package com.cases;

public class MidNumCase {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num1 = new int[] {1,2,2};
        int[] num2 = new int[] {1,2,3};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            nums1 = new int[]{};
        }
        if (nums2 == null) {
            nums2 = new int[]{};
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int sum = length1 + length2;
        if (sum <= 0) {
            return Integer.MIN_VALUE;
        }
        int midIndex = 0;
        int midIndexBack = -1;
        midIndex = sum / 2;
        if (sum % 2 == 0) {
            midIndexBack = midIndex + 1;
        }
        int index1 = 0, index2 = 0, value = 0, lastValue = 0;
        if (length1 > 0) {
            value = nums1[0];
            if (length2 > 0 && nums2[0] < value) {
                value = nums2[0];
            }
        }
        while(index1 < length1 || index2 < length2) {
            if (index1 < length1 && index2 < length2) {
                int value1 = nums1[index1];
                int value2 = nums2[index2];
                if (value1 < value2) {
                    lastValue = value;
                    value = value1;
                    index1++;
                } else if (value1 > value2) {
                    lastValue = value;
                    value = value2;
                    index2++;
                } else {
                    index1 ++;
                    if (index1 + index2 >= (midIndex+1)) {
                        lastValue = value;
                        value = value2;
                        break;
                    }
                    value = value1;
                    lastValue = value;
                    index2 ++;
                    if (index1 + index2 >= (midIndex+1)) {
                        lastValue = value;
                        value = value2;
                        break;
                    }
                    value = value2;
                    lastValue = value;
                }
            } else if (index1 < length1) {
                int value1 = nums1[index1];
                lastValue = value;
                value = value1;
                index1 ++;
            } else {
                int value2 = nums2[index2];
                lastValue = value;
                value = value2;
                index2 ++;
            }
            if (index1 + index2 >= (midIndex+1)) {
                break;
            }
        }
        if (midIndexBack > 0) {
            return (value + lastValue) * 0.5;
        } else {
            return value;
        }
    }
}
