package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.Stack;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeMergeTwoTree {
    private static TreeNode mergeTreesRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val = root1.val + root2.val;
        root1.left = mergeTreesRec(root1.left, root2.left);
        root1.right = mergeTreesRec(root1.right, root2.right);
        return root1;
    }

    private static TreeNode mergeTreesItr(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] arrTree = stack.pop();
            if (arrTree[0] == null || arrTree[1] == null) {
                continue;
            }
            arrTree[0].val += arrTree[1].val;
            if (arrTree[0].left == null) {
                arrTree[0].left = arrTree[1].left;
            } else {
                stack.push(new TreeNode[]{arrTree[0].left, arrTree[1].left});
            }
            if (arrTree[0].right == null) {
                arrTree[0].right = arrTree[1].right;
            } else {
                stack.push(new TreeNode[]{arrTree[0].right, arrTree[1].right});
            }
        }
        return root1;
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Integer[] p1 = {1, 3, 2, 5};
        Integer[] q1 = {2, 1, 3, null, 4, null, 7};
        printTree(mergeTreesRec(createTree(p1), createTree(q1)));
        System.out.println();
        printTree(mergeTreesRec(createTree(p1), createTree(q1)));
        System.out.println();

        Integer[] p2 = {1};
        Integer[] q2 = {1, 2};
        printTree(mergeTreesItr(createTree(p2), createTree(q2)));
        System.out.println();
        printTree(mergeTreesItr(createTree(p2), createTree(q2)));
        System.out.println();

    }
}
