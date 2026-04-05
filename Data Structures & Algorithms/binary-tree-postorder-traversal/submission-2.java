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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        List<Integer> res = new ArrayList<>();
        nodes.push(root);
        visited.push(false);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            boolean isVisited = visited.pop();
            if (node != null) {
                if (!isVisited) {
                    nodes.push(node);
                    visited.push(true);
                    nodes.push(node.right);
                    visited.push(false);
                    nodes.push(node.left);
                    visited.push(false);
                }
                else {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}