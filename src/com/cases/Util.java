package com.cases;

public class Util {
    public static ListNode createList(int[] data) {
        if (data == null || data.length <= 0) {
            return null;
        }
        ListNode result = new ListNode(data[0]);
        ListNode curNode = result;
        for (int index = 1; index < data.length; index ++) {
            ListNode newNode = new ListNode(data[index]);
            newNode.next = null;
            curNode.next = newNode;
            curNode = curNode.next;
        }
        return result;
    }

    public static void printList(ListNode node) {
        while(node != null) {
            System.out.print(node.val);
            System.out.print(",");
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode backNode = head.next;
        while (backNode != null) {
            ListNode tempNode = backNode.next;
            backNode.next = preNode;
            if (preNode == head) {
                preNode.next = null;
            }
            preNode = backNode;
            backNode = tempNode;
        }
        return preNode;
    }
}
