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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode node, int currMax) {
        if (node == null)
            return ;
        if (node.val >= currMax)
            ++count;
        currMax = Math.max(currMax, node.val);
        dfs(node.left, currMax);
        dfs(node.right, currMax);
    }
}
