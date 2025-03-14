package org.hm.problemsolving;

import org.hm.util.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4))
                .setNext(new ListNode(5));
        System.out.println(middleNode(list1).getVal());

        ListNode list2 = new ListNode(1);
        list2.setNext(new ListNode(2)).setNext(new ListNode(3)).setNext(new ListNode(4))
                .setNext(new ListNode(5)).setNext(new ListNode(6));
        System.out.println(middleNode(list2).getVal());
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }
}
