package com.zql.leetcode.tree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    /**
     * 对树进行镜像
     * @param root 镜像的根节点
     * @return 镜像的结果
     */
    public static TreeNode mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

    }
}
