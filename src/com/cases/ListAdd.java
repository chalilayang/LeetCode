package com.cases;

public class ListAdd {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head1 = Util.createList(new int[]{2,4,3});
        ListNode head2 = Util.createList(new int[]{5,6,4});
        ListNode reverseList = addTwoNumbers(head1, head2);
        Util.printList(reverseList);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        int nextValue = 0;
        ListNode curNode = result;
        while(listNode1 != null || listNode2 != null || nextValue > 0) {
            int value1 = 0;
            if (listNode1 != null) {
                value1 = listNode1.val;
                listNode1 = listNode1.next;
            }
            int value2 = 0;
            if (listNode2 != null) {
                value2 = listNode2.val;
                listNode2 = listNode2.next;
            }
            int sum = value1 + value2 + nextValue;
            int value = 0;
            if (sum > 9) {
                nextValue = 1;
                value = sum - 10;
            } else {
                value = sum;
                nextValue = 0;
            }
            ListNode node = new ListNode(value);
            if (curNode != null) {
                curNode.next = node;
            }
            curNode = node;
            if (result == null) {
                result = curNode;
            }
        }
        return result;
    }
}
