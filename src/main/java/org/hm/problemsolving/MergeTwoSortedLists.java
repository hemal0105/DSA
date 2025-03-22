package org.hm.problemsolving;

import org.hm.util.ListNode;

import static org.hm.util.ListNode.printList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of
 * the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.setNext(new ListNode(2)).setNext(new ListNode(4));

        ListNode list2 = new ListNode(1);
        list2.setNext(new ListNode(3)).setNext(new ListNode(4));
        printList(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mHead = new ListNode(-1);
        ListNode mTail = mHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mTail.next = list1;
                list1 = list1.next;
            } else {
                mTail.next = list2;
                list2 = list2.next;
            }
            mTail = mTail.next;
        }
        mTail.next = list1 == null ? list2 : list1;
        return mHead.next;
    }
}
