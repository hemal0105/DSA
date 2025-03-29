package org.hm.datastructures;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Create list with insert at beginning");
        list.createWithInsertAtBeginning();

        System.out.println("Create list with insert at a given position");
        list.createWithInsertAtPos();

        System.out.println("Delete node");
        list.deleteNode(list.createWithInsertAtBeginning());

        System.out.println("Iterative reverse");
        Node head1 = list.reverse(list.createWithInsertAtBeginning());
        list.print(head1);

        System.out.println("Print in reverse with recursion");
        Node head2 = list.createWithInsertAtBeginning();
        list.recRevPrint(head2);
        System.out.println();

        System.out.println("Recursive reverse");
        Node head3 = list.createWithInsertAtBeginning();
        head3 = list.recReverse(head3);
        list.print(head3);
    }

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

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void deleteNode(Node head) {
        head = delete(head, 1);
        print(head);
        head = delete(head, 2);
        print(head);
        head = delete(head, 3);
        print(head);
    }


    private Node createWithInsertAtBeginning() {
        Node head = null;
        head = insertAtBeginning(head, 2);
        head = insertAtBeginning(head, 5);
        head = insertAtBeginning(head, 8);
        head = insertAtBeginning(head, 1);
        head = insertAtBeginning(head, 10);

        print(head);
        System.out.println();
        return head;
    }

    private void createWithInsertAtPos() {
        Node head = null;
        head = insert(head, 2, 1);
        head = insert(head, 3, 2);
        head = insert(head, 4, 1);
        head = insert(head, 5, 2);

        print(head);
        System.out.println();
    }

    private Node insertAtBeginning(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = head;
        head = temp;

        return head;
    }

    private Node insert(Node head, int data, int pos) {
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

    private Node delete(Node head, int pos) {
        if (pos == 1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        for(int i = 0; i < pos-2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    private void print(Node head) {
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
