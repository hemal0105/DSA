package org.hm.problemsolving;

import org.hm.util.TreeNode;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class BinaryTreeDiameter {
    private static int diameter;

    private static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private static int longestPath(TreeNode root) {
        if (root == null) return 0;
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(diameterOfBinaryTree(createTree(arr1)));

        Integer[] arr2 = {1, 2};
        System.out.println(diameterOfBinaryTree(createTree(arr2)));
    }
}
