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
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node) { 
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int arch = node.val + left + right;
        max = Math.max(arch, max);
        int soFar = node.val + Math.max(left, right);
        int ret = Math.max(node.val, soFar);
        max = Math.max(max, ret);
        return ret;
    }
}
