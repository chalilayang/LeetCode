package com.cases;

public class MergeSortedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num1 = new int[] {1,2,2};
        int[] num2 = new int[] {0,3,3,4};
        int[] num3 = new int[] {2,5,6};
        ListNode[] listNodes = new ListNode[] {Util.createList(num1), Util.createList(num2), Util.createList(num3)};
        Util.printList(mergeKLists(listNodes));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if (lists == null || lists.length == 0) {
            return result;
        }
        int count = lists.length;
        ListNode[] curNodes = new ListNode[count];
        System.arraycopy(lists, 0, curNodes, 0, count);
        ListNode curNode = result;
        while(true) {
            boolean reachEnd = true;
            for (int index = 0; index < count; index ++) {
                if (curNodes[index] != null) {
                    reachEnd = false;
                    break;
                }
            }
            if (reachEnd) {
                break;
            }
            int curValue = Integer.MAX_VALUE;
            int curIndex = -1;
            for (int index = 0; index < count; index ++) {
                if (curNodes[index] != null && curNodes[index].val <= curValue) {
                    curValue = curNodes[index].val;
                    curIndex = index;
                }
            }
            if (curIndex >= 0) {
                curNodes[curIndex] = curNodes[curIndex].next;
                ListNode newNode = new ListNode(curValue);
                if (curNode == null) {
                    result = newNode;
                    curNode = result;
                } else {
                    curNode.next = newNode;
                    curNode = newNode;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
