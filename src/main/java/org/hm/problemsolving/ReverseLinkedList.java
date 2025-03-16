package org.hm.problemsolving;

import org.hm.util.ListNode;

import static org.hm.util.ListNode.printList;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4))
                .setNext(new ListNode(5)).setNext(new ListNode(6));
        printList(reverseListRec(list));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRec(head.next);
        head.next.next = head;
        head.setNext(null);
        return p; // new head after reversing
    }
}
