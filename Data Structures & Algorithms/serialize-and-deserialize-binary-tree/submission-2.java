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


// bfs
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> values = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null) {
                    values.add("n");
                    continue;
                }
                values.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return String.join(",", values);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int idx = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (vals[0].equals("n"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[idx++]));
        queue.add(root);
        while (idx < vals.length) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                node.left = vals[idx].equals("n") ? 
                            null :
                            new TreeNode(Integer.parseInt(vals[idx]));
                idx++;
                node.right = vals[idx].equals("n") ? 
                            null :
                            new TreeNode(Integer.parseInt(vals[idx]));
                idx++;
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return root;
    }
}
