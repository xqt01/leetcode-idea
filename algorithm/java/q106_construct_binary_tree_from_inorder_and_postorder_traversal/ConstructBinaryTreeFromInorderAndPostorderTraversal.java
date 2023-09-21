package q106_construct_binary_tree_from_inorder_and_postorder_traversal;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {}
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = inStart;
        int sizeOfLeft = 0;
        while (inorder[i] != postorder[postEnd]) {
            i++;
            sizeOfLeft++;
        }
        root.left = buildTree(inorder, postorder, inStart, i - 1, postStart, postStart + sizeOfLeft - 1);
        root.right = buildTree(inorder, postorder, i + 1, inEnd, postStart + sizeOfLeft, postEnd - 1);
        return root;
    }
}