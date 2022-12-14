package com.codeing.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode : https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 난이도 : easy
 */
public class BinaryTreeInorder {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


     List<Integer> list = Collections.emptyList();
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        inorder(root);
        return list;
    }

    public void inorder(TreeNode node){
        if(node !=null){
            if(node.left !=null) inorder(node.left);
            list.add(node.val);
            if(node.right !=null) inorder(node.right);
        }

    }
}
