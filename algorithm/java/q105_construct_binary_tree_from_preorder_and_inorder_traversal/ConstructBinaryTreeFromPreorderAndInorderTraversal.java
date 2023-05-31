package q105_construct_binary_tree_from_preorder_and_inorder_traversal;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {}
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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = inStart;
        for (;i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                break;
            }
        }
        int leftTreeSize = i - inStart;
        int rightTreeSzie = inEnd - i;
        root.left = buildTree(preorder, inorder, preStart + 1, preStart + leftTreeSize, inStart, i - 1);
        root.right = buildTree(preorder, inorder, preStart + leftTreeSize + 1, preEnd, i + 1, inEnd);
        return root;
    }
}