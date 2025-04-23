package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.LinkedList;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeHasPathSum {
    private static boolean hasPathSumRec(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;
        if (root.left == null && root.right == null) return (targetSum == 0);
        return hasPathSumRec(root.left, targetSum) || hasPathSumRec(root.right, targetSum);
    }

    private static boolean hasPathSumItr(TreeNode root, int targetSum) {
        if (root == null) return false;

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(targetSum - root.val);

        TreeNode node;
        int currSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            currSum = sumStack.pollLast();
            if (node.left == null && node.right == null && currSum == 0) return true;
            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currSum - node.right.val);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currSum - node.left.val);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        System.out.println(hasPathSumRec(createTree(arr1), 22));
        System.out.println(hasPathSumItr(createTree(arr1), 22));

        Integer[] arr2 = {1, 2, 3};
        System.out.println(hasPathSumRec(createTree(arr2), 5));
        System.out.println(hasPathSumItr(createTree(arr2), 5));

        Integer[] arr3 = {};
        System.out.println(hasPathSumRec(createTree(arr3), 0));
        System.out.println(hasPathSumItr(createTree(arr3), 0));
    }
}
