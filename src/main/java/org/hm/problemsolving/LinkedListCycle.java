package org.hm.problemsolving;

/**
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode cycleNode = new ListNode(2);
        ListNode list1 = new ListNode(3).setNext(cycleNode).setNext(new ListNode(0))
                .setNext(new ListNode(-4)).setNext(cycleNode);
        System.out.println(hasCycle(list1));

        ListNode list2 = new ListNode(3).setNext(new ListNode(0)).setNext(new ListNode(-4));
        System.out.println(hasCycle(list2));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode setNext(ListNode listNode) {
        this.next = listNode;
        return listNode;
    }
}
