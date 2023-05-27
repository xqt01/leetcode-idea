package q297_serialize_and_deserialize_binary_tree;

public class SerializeAndDeserializeBinaryTree {}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(sb, root.left);
        serialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.add(s);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        if (list.size() == 0) {
            return null;
        }
        String sval = list.removeFirst();
        if (Objects.equals(sval, "#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(sval));

        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));