package org.hm.problemsolving;

import org.hm.util.TreeNode;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeMergeTwoTree {
    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Integer[] p1 = {1,3,2,5};
        Integer[] q1 = {2,1,3,null,4,null,7};
        printTree(mergeTrees(createTree(p1), createTree(q1)));
        System.out.println();

        Integer[] p2 = {1};
        Integer[] q2 = {1, 2};
        printTree(mergeTrees(createTree(p2), createTree(q2)));
        System.out.println();

    }
}
