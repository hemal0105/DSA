package org.hm.util;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public int getVal() {
        return this.val;
    }

    public ListNode getNext() {
        return this.next;
    }

    public ListNode setNext(ListNode listNode) {
        this.next = listNode;
        return listNode;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
