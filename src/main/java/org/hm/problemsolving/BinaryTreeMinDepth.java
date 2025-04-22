package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeMinDepth {
    private static int minDepthDfs(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return minDepthDfs(root.right) + 1;
        else if (root.right == null) return minDepthDfs(root.left) + 1;

        return Integer.min(minDepthDfs(root.left), minDepthDfs(root.right)) + 1;
    }

    private static int minDepthBfs(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int qLen = q.size();
            while (qLen > 0) {
                qLen--;

                TreeNode node = q.remove();
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            depth++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        System.out.println(minDepthDfs(createTree(arr1)));
        System.out.println(minDepthBfs(createTree(arr1)));

        Integer[] arr2 = {2, null, 3, null, 4, null, 5, null, 6};
        System.out.println(minDepthDfs(createTree(arr2)));
        System.out.println(minDepthBfs(createTree(arr2)));
    }
}
