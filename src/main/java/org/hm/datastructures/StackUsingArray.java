package org.hm.datastructures;

import java.util.Arrays;

/**
 * Stack with array based implementation which allows fixed elements based on size of Array.
 * If Array is full, a larger array needs to be created and we need to copy all elements to it.
 */
public class StackUsingArray {
    private final int MAX_SIZE = 5;
    private final int[] arr = new int[MAX_SIZE];
    private int top = -1;

    public void push(int data) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack full");
            return;
        }
        arr[++top] = data;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack empty");
            return;
        }
        arr[top] = 0;
        top--;
    }

    public int top() {
        return arr[top];
    }

    public void print() {
        System.out.println("Stack: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(2); stack.print();
        stack.push(5); stack.print();
        stack.push(10); stack.print();
        stack.pop(); stack.print();
        stack.push(12); stack.print();
        System.out.println(stack.top());
    }
}
