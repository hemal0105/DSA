package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeInvert {
    private static TreeNode invertTreeRec(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTreeRec(root.right);
        TreeNode left = invertTreeRec(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    private static TreeNode invertTreeItr(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    private static void levelOrderTraversal(TreeNode root) {
        System.out.print("Level Order Traversal: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            queue.poll();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr1 = {4, 2, 7, 1, 3, 6, 9};
        levelOrderTraversal(invertTreeRec(createTree(arr1)));
        levelOrderTraversal(invertTreeItr(createTree(arr1)));

        Integer[] arr2 = {2, 1, 3};
        levelOrderTraversal(invertTreeRec(createTree(arr2)));
        levelOrderTraversal(invertTreeItr(createTree(arr2)));
    }
}
