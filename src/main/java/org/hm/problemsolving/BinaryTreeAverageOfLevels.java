package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *           3
 *        /     \
 *       9       20
 *     /   \    /  \
 *   null null 15   7
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 */
public class BinaryTreeAverageOfLevels {
    private static List<Double> averageOfLevelsBfs(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            long sum = 0;
            long count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                sum += node.val;
                count++;

                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            result.add((double) sum / count);
        }
        return result;
    }

    private static List<Double> averageOfLevelsDfs(TreeNode root) {
        List<Double> result = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        addSumAndCount(root, 0, result, count);

        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i) / count.get(i));
        }
        return result;
    }

    private static void addSumAndCount(TreeNode root, int level, List<Double> sum, List<Integer> count) {
        if (root == null) return;
        if (level < sum.size()) {
            sum.set(level, sum.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        } else {
            sum.add(root.val * 1.0);
            count.add(1);
        }
        addSumAndCount(root.left, level + 1, sum, count);
        addSumAndCount(root.right, level + 1, sum, count);
    }

    public static TreeNode createTree(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        if (arr.length == 2) {
            root.left = new TreeNode(arr[1]);
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode temp = queue.remove();
            Integer leftVal = arr[i++];
            Integer rightVal = arr[i++];
            if (leftVal != null) {
                temp.left = new TreeNode(leftVal);
                queue.add(temp.left);
            }
            if (rightVal != null) {
                temp.right = new TreeNode(rightVal);
                queue.add(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        System.out.println(averageOfLevelsBfs(createTree(arr1)));
        System.out.println(averageOfLevelsDfs(createTree(arr1)));

        Integer[] arr2 = {3, 9, 20, 15, 7};
        System.out.println(averageOfLevelsBfs(createTree(arr2)));
        System.out.println(averageOfLevelsDfs(createTree(arr2)));

        Integer[] arr3 = {0, -1};
        System.out.println(averageOfLevelsBfs(createTree(arr3)));
        System.out.println(averageOfLevelsDfs(createTree(arr3)));
    }
}


