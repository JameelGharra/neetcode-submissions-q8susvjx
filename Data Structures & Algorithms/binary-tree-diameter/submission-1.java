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
    // recur
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        d[0] = 0;
        recur(root, d);
        return d[0];
    }

    private int recur(TreeNode node, int[] d) {
        if (node == null)
            return 0;

        int left = recur(node.left, d);
        int right = recur(node.right, d);
        d[0] = Math.max(d[0],left + right);
        return 1 + Math.max(left, right);
    }
}
