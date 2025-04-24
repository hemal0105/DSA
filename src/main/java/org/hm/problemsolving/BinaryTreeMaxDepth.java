package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeMaxDepth {
    private static int maxDepthDfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return maxDepthDfs(root.right) + 1;
        if (root.right == null) return maxDepthDfs(root.left) + 1;
        return Integer.max(maxDepthDfs(root.left), maxDepthDfs(root.right)) + 1;
    }

    private static int maxDepthBfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            Queue<TreeNode> qLevel = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode qNode = q.poll();
                if (qNode.left != null) qLevel.add(qNode.left);
                if (qNode.right != null) qLevel.add(qNode.right);
            }
            depth++;
            q = qLevel;
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        System.out.println(maxDepthDfs(createTree(arr1)));
        System.out.println(maxDepthBfs(createTree(arr1)));

        Integer[] arr2 = {2, null, 3, null, 4, null, 5, null, 6};
        System.out.println(maxDepthDfs(createTree(arr2)));
        System.out.println(maxDepthBfs(createTree(arr2)));

        Integer[] arr3 = {1, null, 2};
        System.out.println(maxDepthDfs(createTree(arr3)));
        System.out.println(maxDepthBfs(createTree(arr3)));
    }
}
