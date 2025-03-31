package org.hm.datastructures;

import java.util.Stack;

import static org.hm.datastructures.LinkedList.createWithInsertAtBeginning;

public class StackReverseLinkedList {
    private static void reverse(LinkedList list) {
        Stack<Node> stack = new Stack<>();
        Node temp = list.getHead();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = stack.pop();
        Node head = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        list.setHead(head);
    }

    public static void main(String[] args) {
        LinkedList list = createWithInsertAtBeginning();
        reverse(list);
        list.print();
    }
}
