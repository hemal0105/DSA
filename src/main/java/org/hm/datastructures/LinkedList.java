package org.hm.datastructures;

public class LinkedList {
    private Node head = null;

    private Node recReverse(Node head) {
        if (head.next == null) return head;

        Node newHead = recReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void recRevPrint(Node head) {
        if (head == null) return;
        recRevPrint(head.next);
        System.out.print(head.data + " ");
    }

    private void reverse() {
        Node prev = null;
        Node curr = this.head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    private void insertAtBeginning(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = this.head;
        this.head = temp;
    }

    private void insert(int data, int pos) {
        Node newNode = new Node();
        newNode.data = data;
        if (pos == 1) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < pos - 2; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private void delete(int pos) {
        if (pos == 1) {
            this.head = this.head.next;
            return;
        }
        Node temp = this.head;
        for (int i = 0; i < pos - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    private Node getHead() {
        return this.head;
    }

    private void setHead(Node node) {
        this.head = node;
    }

    private void print() {
        Node temp = this.head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Create list with insert at beginning");
        createWithInsertAtBeginning();

        System.out.println("Create list with insert at a given position");
        createWithInsertAtPos();

        System.out.println("Delete node");
        deleteNodes(createWithInsertAtBeginning());

        System.out.println("Iterative reverse");
        LinkedList list1 = createWithInsertAtBeginning();
        list1.reverse();
        list1.print();

        System.out.println("Print in reverse with recursion");
        LinkedList list2 = createWithInsertAtBeginning();
        list2.recRevPrint(list2.getHead());
        System.out.println();

        System.out.println("Recursive reverse");
        LinkedList list3 = createWithInsertAtBeginning();
        Node newHead = list3.recReverse(list3.getHead());
        list3.setHead(newHead);
        list3.print();
    }

    private static void deleteNodes(LinkedList list) {
        list.delete(1);
        list.print();
        list.delete(2);
        list.print();
        list.delete(3);
        list.print();
    }


    private static LinkedList createWithInsertAtBeginning() {
        LinkedList list = new LinkedList();
        list.insertAtBeginning(2);
        list.insertAtBeginning(5);
        list.insertAtBeginning(8);
        list.insertAtBeginning(1);
        list.insertAtBeginning(10);

        list.print();
        System.out.println();
        return list;
    }

    private static void createWithInsertAtPos() {
        LinkedList list = new LinkedList();
        list.insert(2, 1);
        list.insert(3, 2);
        list.insert(4, 1);
        list.insert(5, 2);

        list.print();
        System.out.println();
    }
}

class Node {
    int data;
    Node next;
}
