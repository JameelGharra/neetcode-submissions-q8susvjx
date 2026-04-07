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

// dfs same approach just using split for cleaner
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeTreeValues(root, res);
        return String.join(",", res);
    }

    private void serializeTreeValues(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("n");
            return ;
        }
        list.add(String.valueOf(node.val));
        serializeTreeValues(node.left, list);
        serializeTreeValues(node.right, list);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] idx = {0};
        return deserializeTree(vals, idx);
    }
    private TreeNode deserializeTree(String[] vals, int[] idx) {
        if (vals[idx[0]].equals("n")) {
            idx[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[idx[0]++]));
        node.left = deserializeTree(vals, idx);
        node.right = deserializeTree(vals, idx);
        return node;
    }
}
