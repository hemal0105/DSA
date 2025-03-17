package org.hm.problemsolving;

import org.hm.util.ListNode;

import static org.hm.util.ListNode.printList;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears
 * only once. Return the linked list sorted as well.
 */
public class RemoveDupesSortedLinkedList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.setNext(new ListNode(1)).setNext(new ListNode(2)).setNext(new ListNode(3))
                .setNext(new ListNode(3));
        printList(deleteDuplicates(list));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
