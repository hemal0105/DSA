package org.hm.datastructures;

public class LinkedList {

    public static void main(String[] args) {
        Node head = null;
        LinkedList list = new LinkedList();
        head = list.insertAtBeginning(head, 2);
        head = list.insertAtBeginning(head, 5);
        head = list.insertAtBeginning(head, 8);
        head = list.insertAtBeginning(head, 1);
        head = list.insertAtBeginning(head, 10);

        list.print(head);
    }

    public Node insertAtBeginning(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;

        return head;
    }

    public void print(Node head) {
        Node temp = head;
        System.out.print("List: ");
        while(temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;
}
