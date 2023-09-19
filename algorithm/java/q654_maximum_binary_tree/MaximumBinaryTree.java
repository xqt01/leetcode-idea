package q654_maximum_binary_tree;

public class MaximumBinaryTree {}
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int indexOfMax = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[indexOfMax]) {
                indexOfMax = i;
            }
        }
        TreeNode root = new TreeNode(nums[indexOfMax]);
        root.left = constructMaximumBinaryTree(nums, start, indexOfMax - 1);
        root.right = constructMaximumBinaryTree(nums, indexOfMax + 1, end);
        return root;
    }
}