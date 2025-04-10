package org.hm.datastructures;

import java.util.LinkedList;
import java.util.Queue;

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

    private int findMinItr(BstNode root) {
        if (root == null) return -1;
        while(root.left != null) root = root.left;
        return root.data;
    }

    private BstNode findMinRec(BstNode root) {
        if (root == null) return null;
        if (root.left == null) return root;
        return findMinRec(root.left);
    }



    private int findHeight(BstNode root) {
        if (root == null) {
            return -1;
        }
        return Integer.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    private void levelOrderTraversal(BstNode root) {
        System.out.print("Level Order Traversal: ");
        Queue<BstNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BstNode node = queue.peek();
            System.out.print(node.data + " ");
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            queue.poll();
        }
        System.out.println();
    }

    private void preOrderDfs(BstNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderDfs(root.left);
        preOrderDfs(root.right);
    }

    private void inOrderDfs(BstNode root) {
        if (root == null) return;
        inOrderDfs(root.left);
        System.out.print(root.data + " ");
        inOrderDfs(root.right);
    }

    private void postOrderDfs(BstNode root) {
        if (root == null) return;
        postOrderDfs(root.left);
        postOrderDfs(root.right);
        System.out.print(root.data + " ");
    }

    private boolean isBstUtil(BstNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if ((root.data > minValue)
                && (root.data < maxValue)
                && isBstUtil(root.left, minValue, root.data)
                && isBstUtil(root.right, root.data, maxValue)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBst(BstNode root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BstNode delete(BstNode root, int data) {
        if (root == null) return root;
        else if (data < root.data) root.left = delete(root.left, data);
        else if (data > root.data) root.right = delete(root.right, data);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int minFromRight = findMinItr(root.right);
                root.data = minFromRight;
                root.right = delete(root.right, minFromRight);
            }
        }
        return root;
    }

    private BstNode find(BstNode root, int data) {
        if (root == null) return null;
        else if (data < root.data) return find(root.left, data);
        else if (data > root.data) return find(root.right, data);
        else return root;
    }

    private BstNode inOrderSuccessor(BstNode root, int data) {
        BstNode current = find(root, data);
        if (current == null) return null;
        if (current.right != null) return findMinRec(root);
        else {
            BstNode successor = null;
            BstNode ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
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

        System.out.println("Find Min Iterative: " + tree.findMinItr(root));
        System.out.println("Find Min Recursive: " + tree.findMinRec(root));

        int height = tree.findHeight(root);
        System.out.println("Tree Height: " + height);

        tree.levelOrderTraversal(root);

        System.out.print("preOrderDfs: ");
        tree.preOrderDfs(root);
        System.out.println();

        System.out.print("inOrderDfs: ");
        tree.inOrderDfs(root);
        System.out.println();

        System.out.print("postOrderDfs: ");
        tree.postOrderDfs(root);
        System.out.println();

        System.out.println("Is BST: " + tree.isBst(root));

        tree.levelOrderTraversal(tree.delete(root, 15));

        BstNode successor = tree.inOrderSuccessor(root, 8);
        System.out.println("InOrder Successor: " + (successor != null ? successor.data : "Not Found"));
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
