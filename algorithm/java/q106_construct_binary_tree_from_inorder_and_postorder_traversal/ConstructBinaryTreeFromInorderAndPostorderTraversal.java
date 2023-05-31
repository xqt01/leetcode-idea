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

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = inStart;
        for (; index < inEnd; index++) {
            if (inorder[index] == postorder[postEnd]) {
                break;
            }
        }
        int leftTreeSize = index - inStart;
        root.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart + leftTreeSize - 1);
        root.right = buildTree(inorder, postorder, index + 1, inEnd, postStart + leftTreeSize, postEnd - 1);
        return root;
    }
}