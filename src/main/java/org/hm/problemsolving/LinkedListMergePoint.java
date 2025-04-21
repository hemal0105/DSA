package org.hm.problemsolving;

import org.hm.util.ListNode;

public class LinkedListMergePoint {
    private static ListNode findMergePoint(ListNode list1, ListNode list2) {
        int len1 = length(list1);
        int len2 = length(list2);

        int diff = len2 - len1;
        if (len1 > len2) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
            diff = len1 - len2;
        }
        for (int i = 0; i < diff; i++) list2 = list2.next;

        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return null;
    }

    private static int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        ListNode mergedList = new ListNode(7);
        mergedList.setNext(new ListNode(1));

        ListNode list1 = new ListNode(4);
        list1.setNext(new ListNode(6)).setNext(mergedList);

        ListNode list2 = new ListNode(9);
        list2.setNext(new ListNode(3)).setNext(new ListNode(5)).setNext(mergedList);

        ListNode mergePoint = findMergePoint(list2, list1);
        if (mergePoint != null) {
            System.out.println(mergePoint.val);
        } else {
            System.out.println("No merge point found");
        }
    }
}
