package org.hm.datastructures;

public class LinkedList {

    public static void main(String[] args) {
        createWithInsertAtBeginning();
        createWithInsertAtPos();
    }


    public static void createWithInsertAtBeginning() {
        System.out.println("createWithInsertAtBeginning");
        Node head = null;
        LinkedList list = new LinkedList();
        head = list.insertAtBeginning(head, 2);
        head = list.insertAtBeginning(head, 5);
        head = list.insertAtBeginning(head, 8);
        head = list.insertAtBeginning(head, 1);
        head = list.insertAtBeginning(head, 10);

        list.print(head);
    }

    public static void createWithInsertAtPos() {
        System.out.println("createWithInsertAtPos");
        Node head = null;
        LinkedList list = new LinkedList();
        head = list.insert(head, 2, 1);
        head = list.insert(head, 3, 2);
        head = list.insert(head, 4, 1);
        head = list.insert(head, 5, 2);

        list.print(head);
    }

    public Node insertAtBeginning(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;

        return head;
    }

    public Node insert(Node head, int data, int pos) {
        Node newNode = new Node();
        newNode.data = data;
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node temp = head;
        for(int i = 0; i < pos-2; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    public void print(Node head) {
        Node temp = head;
        System.out.print("List: ");
        while(temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println("\n");
    }
}

class Node {
    int data;
    Node next;
}
