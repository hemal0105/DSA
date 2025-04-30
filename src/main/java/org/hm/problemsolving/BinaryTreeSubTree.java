package org.hm.problemsolving;

import org.hm.util.TreeNode;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeSubTree {

    private static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer[] p1 = {3, 4, 5, 1, 2};
        Integer[] q1 = {4, 1, 2};
        System.out.println(isSubTree(createTree(p1), createTree(q1)));

        Integer[] p2 = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] q2 = {4, 1, 2};
        System.out.println(isSubTree(createTree(p2), createTree(q2)));
    }
}
