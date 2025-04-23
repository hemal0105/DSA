package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreeSameTree {
    private static boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTreeRec(p.left, q.left) && isSameTreeRec(p.right, q.right);
    }


    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return true;
    }

    private static boolean isSameTreeItr(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while(!pQueue.isEmpty()) {
            p = pQueue.remove();
            q = qQueue.remove();

            if (!check(p, q)) return false;
            if (p != null) {
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    pQueue.add(p.left);
                    qQueue.add(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    pQueue.add(p.right);
                    qQueue.add(q.right);
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Integer[] p1 = {1, 2, 3};
        Integer[] q1 = {1, 2, 3};
        System.out.println(isSameTreeRec(createTree(p1), createTree(q1)));
        System.out.println(isSameTreeItr(createTree(p1), createTree(q1)));

        Integer[] p2 = {1, 2};
        Integer[] q2 = {1, null, 2};
        System.out.println(isSameTreeRec(createTree(p2), createTree(q2)));
        System.out.println(isSameTreeItr(createTree(p2), createTree(q2)));

        Integer[] p3 = {1, 2, 1};
        Integer[] q3 = {1, 1, 2};
        System.out.println(isSameTreeRec(createTree(p3), createTree(q3)));
        System.out.println(isSameTreeItr(createTree(p3), createTree(q3)));


    }
}
