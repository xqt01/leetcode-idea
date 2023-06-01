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

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return result;
    }

    public String find(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = find(root.left);
        String right = find(root.right);
        String tree = root.val + "," + left + "," + right + ",";
        if (map.get(tree) == null) {
            map.put(tree, 1);
        } else if (map.get(tree) == 1){
            map.put(tree, 2);
            result.add(root);
        }
        return tree;
    }
}