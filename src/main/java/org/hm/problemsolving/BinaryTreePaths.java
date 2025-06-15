package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.hm.problemsolving.BinaryTreeAverageOfLevels.createTree;

public class BinaryTreePaths {

    private static void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }

    private static List<String> binaryTreePathsRec(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private static List<String> binaryTreePathsItr(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<String> pathStack = new LinkedList<>();
        nodeStack.add(root);
        pathStack.add(Integer.toString(root.val));

        TreeNode node;
        String path;

        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            path = pathStack.pollLast();
            if (node.left == null && node.right == null) paths.add(path);
            if (node.left != null) {
                nodeStack.add(node.left);
                pathStack.add(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                pathStack.add(path + "->" + node.right.val);
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, null, 5};
        System.out.println(binaryTreePathsRec(createTree(arr1)));
        System.out.println(binaryTreePathsItr(createTree(arr1)));

        Integer[] arr2 = {1};
        System.out.println(binaryTreePathsRec(createTree(arr2)));
        System.out.println(binaryTreePathsItr(createTree(arr2)));
    }
}
