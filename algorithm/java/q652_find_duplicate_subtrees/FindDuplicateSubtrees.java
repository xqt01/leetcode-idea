package q652_find_duplicate_subtrees;

public class FindDuplicateSubtrees {}
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

    List<TreeNode> res = new LinkedList<>();
    Map<String, Integer> countMap = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return res;
    }

    private String find(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String leftVal = find(root.left);
        String rightVal = find(root.right);
        String encodeSubTree = root.val + "#" + leftVal + "#" + rightVal;
        Integer count = countMap.get(encodeSubTree);
        if (count == null) {
            countMap.put(encodeSubTree, 1);
        } else if (count == 1) {
            countMap.put(encodeSubTree, 2);
            res.add(root);
        }
        return encodeSubTree;
    }
}