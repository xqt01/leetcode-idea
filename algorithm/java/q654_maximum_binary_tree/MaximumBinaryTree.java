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
        int maxIndex = start;
        int maxValue = nums[maxIndex];
        int index = start;
        while (index <= end) {
            if (nums[index] > maxValue) {
                maxIndex = index;
                maxValue = nums[index];
            }
            index++;
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}