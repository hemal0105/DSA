package org.hm.problemsolving;

import org.hm.util.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.setNext(new ListNode(2)).setNext(new ListNode(2)).setNext(new ListNode(1));
        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode endOfFirstHalf = endOfFirstHalf(head);
        ListNode secondReversedHalf = reverseList(endOfFirstHalf.next);

        ListNode part1 = head;
        ListNode part2 = secondReversedHalf;

        boolean isPalindrome = true;
        while (isPalindrome && part2 != null) {
            if (part1.val != part2.val) {
                isPalindrome = false;
            }
            part1 = part1.next;
            part2 = part2.next;
        }

        endOfFirstHalf.next = reverseList(secondReversedHalf);
        return isPalindrome;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
