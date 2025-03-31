package org.hm.datastructures;

public class QueueUsingLinkedList {
    private final LinkedList list;
    private Node front = null;
    private Node rear = null;

    public QueueUsingLinkedList() {
        list = new LinkedList();
    }

    public void enqueue(int data) {
        Node node = new Node();
        node.data = data;
        if (isEmpty()) {
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public int front() {
        return front.data;
    }

    public void dequeue() {
        if (front == rear) {
            front = null;
            rear = null;
            return;
        }
        front = front.next;
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void print() {
        list.setHead(front);
        list.print();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(7);
        queue.print();
        queue.enqueue(3);
        queue.print();
        queue.enqueue(1);
        queue.print();
        queue.enqueue(9);
        queue.print();
        queue.enqueue(10);
        queue.print();
        queue.enqueue(4);
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(6);
        queue.print();
        queue.enqueue(2);
        queue.print();
        System.out.println("Front: " + queue.front());
        queue.dequeue();
        queue.print();
    }
}
