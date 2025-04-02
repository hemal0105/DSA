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


    public static void main(String[] args) {
        BstNode root = null;
        BinarySearchTree tree = new BinarySearchTree();
        root = tree.insert(root, 15);
        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 25);
        root = tree.insert(root, 8);
        tree.insert(root, 12);
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
