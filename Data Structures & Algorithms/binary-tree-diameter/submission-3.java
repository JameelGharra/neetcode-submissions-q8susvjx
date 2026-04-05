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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return diameter;
    }

    private int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recur(node.left);
        int right = recur(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}
