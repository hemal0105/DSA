package org.hm.datastructures;

public class StackUsingLinkedList {
    private final LinkedList list;

    public StackUsingLinkedList() {
        list = new LinkedList();
    }

    public void push(int data) {
        list.insert(data, 1);
    }

    public void pop() {
        list.delete(1);
    }

    public int top() {
        return list.getHead().getData();
    }

    public void print() {
        list.print();
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2); stack.print();
        stack.push(5); stack.print();
        stack.push(10); stack.print();
        stack.pop(); stack.print();
        stack.push(12); stack.print();
        System.out.println(stack.top());
    }
}
