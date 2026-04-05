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
    public int maxDepth(TreeNode root) {
        return recurDepth(0, root);
    }

    private int recurDepth(int depth, TreeNode node) {
        if (node == null)
            return depth;
        int leftDepth = recurDepth(depth+1, node.left);
        int rightDepth = recurDepth(depth+1, node.right);
        return Math.max(leftDepth, rightDepth);
    }
}
