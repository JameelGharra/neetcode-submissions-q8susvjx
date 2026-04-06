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

public class Codec {

    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return serializedTree(root, sb).toString();
    }

    // '#' to represent null values 
    private StringBuilder serializedTree(TreeNode node, StringBuilder sb) {
        if (node == null)
            return sb.append('n');
        sb.append("#").append(node.val);
        serializedTree(node.left, sb);
        serializedTree(node.right, sb);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        return deserializedTree(data);
    }
    private int idx;
    private TreeNode deserializedTree(String data) {
        char c = data.charAt(idx);
        if (c == '#') {
            StringBuilder sb = new StringBuilder();
            while (++idx != data.length() && ((c = data.charAt(idx)) != '#')
            && c != 'n') {
                sb.append(c);
            }
            int val = Integer.parseInt(sb.toString());
            TreeNode node = new TreeNode(val);
            node.left = deserializedTree(data);
            node.right = deserializedTree(data);
            return node;
        }
        else if (c == 'n') {
            idx++;
            return null;
        }
        return null; // never happens
    }
}
