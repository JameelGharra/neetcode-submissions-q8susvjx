/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca;
    // boolean flags
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    private boolean[] dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || lca != null)
            return new boolean[2];
        boolean[] left = dfs(root.left, p, q);
        boolean[] right = dfs(root.right, p, q);
        boolean foundP = left[0] || root == p || right[0];
        boolean foundQ = left[1] || root == q || right[1];
        if (foundP && foundQ && lca == null) {
            lca = root;
        }
        return new boolean[]{foundP, foundQ};
    }
}