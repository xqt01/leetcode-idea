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

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftTreeSize = 0;
        int i = inStart;
        while (inorder[i] != preorder[preStart]) {
            i++;
            leftTreeSize++;
        }
        root.left = buildTree(preorder, inorder, preStart + 1, preEnd + leftTreeSize, inStart, i - 1);
        root.right = buildTree(preorder, inorder, preStart + leftTreeSize + 1, preEnd, i + 1, inEnd);
        return root;
    }
}