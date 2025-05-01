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

    private static boolean isSubTreeStr(TreeNode root, TreeNode subRoot) {
        StringBuilder sbRootTree = new StringBuilder();
        serialize(root, sbRootTree);
        String rootStr = sbRootTree.toString();

        StringBuilder sbSubRootTree = new StringBuilder();
        serialize(subRoot, sbSubRootTree);
        String subRootStr = sbSubRootTree.toString();

        System.out.println(rootStr);
        System.out.println(subRootStr);
        return rootStr.contains(subRootStr);
    }

    private static void serialize(TreeNode node, StringBuilder strTree) {
        if (node == null) {
            strTree.append("#");
            return;
        }

        strTree.append("^");
        strTree.append(node.val);
        serialize(node.left, strTree);
        serialize(node.right, strTree);
    }

    public static void main(String[] args) {
        Integer[] p1 = {3, 4, 5, 1, 2};
        Integer[] q1 = {4, 1, 2};
        System.out.println(isSubTree(createTree(p1), createTree(q1)));
        System.out.println(isSubTreeStr(createTree(p1), createTree(q1)));

        Integer[] p2 = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] q2 = {4, 1, 2};
        System.out.println(isSubTree(createTree(p2), createTree(q2)));
        System.out.println(isSubTreeStr(createTree(p2), createTree(q2)));
    }
}
