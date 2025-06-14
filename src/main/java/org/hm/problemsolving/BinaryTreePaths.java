package org.hm.problemsolving;

import org.hm.util.TreeNode;

import java.util.ArrayList;
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

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, null, 5};
        System.out.println(binaryTreePaths(createTree(arr1)));

        Integer[] arr2 = {1};
        System.out.println(binaryTreePaths(createTree(arr2)));
    }
}
