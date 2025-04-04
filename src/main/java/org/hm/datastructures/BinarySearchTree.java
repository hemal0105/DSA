package org.hm.datastructures;

public class BinarySearchTree {

    private BstNode insert(BstNode root, int data) {
        if (root == null) {
            root = new BstNode(data);
            return root;
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private boolean search(BstNode root, int data) {
        if(root == null) return false;
        else if(root.data == data) return true;
        else if (data <= root.data) return search(root.left, data);
        else return search(root.right, data);
    }

    private int findHeight(BstNode root) {
        if (root == null) {
            return -1;
        }
        return Integer.max(findHeight(root.left), findHeight(root.right)) + 1;
    }


    public static void main(String[] args) {
        BstNode root = null;
        BinarySearchTree tree = new BinarySearchTree();
        root = tree.insert(root, 15);
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 25);
        root = tree.insert(root, 8);
        root = tree.insert(root, 12);
        System.out.println("Search 8: " + tree.search(root, 8));
        System.out.println("Search 18: " + tree.search(root, 18));
        int height = tree.findHeight(root);
        System.out.println("Tree Height: " + height);
    }
}

class BstNode {
    int data;
    BstNode left;
    BstNode right;

    public BstNode(int data) {
        this.data = data;
    }
}
