package org.hm.problemsolving;

import org.hm.util.ListNode;

import static org.hm.util.ListNode.printList;

public class RemoveLinkedListElement {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.setNext(new ListNode(2)).setNext(new ListNode(6)).setNext(new ListNode(3))
                .setNext(new ListNode(4)).setNext(new ListNode(5)).setNext(new ListNode(6));
        printList(removeElements(list, 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
