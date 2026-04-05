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

// iterative
class Solution {
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Map<TreeNode, Integer> depths = new HashMap<>();
        depths.put(null, 0);
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node == null) {
                continue;
            }
            boolean isVisited = depths.containsKey(node);
            if (!isVisited) {
                depths.put(node, 0);
                nodes.push(node);
                nodes.push(node.right);
                nodes.push(node.left);
            }
            else {
                int leftHeight = depths.get(node.left);
                int rightHeight = depths.get(node.right);
                if (Math.abs(leftHeight-rightHeight) > 1) return false;
                depths.put(node, 1 + Math.max(leftHeight, rightHeight));
            }
        }
        return true;
    }
}
