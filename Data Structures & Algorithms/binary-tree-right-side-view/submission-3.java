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
    private List<Integer> res = new ArrayList<>();
    // dfs
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null)
            return ;
        if (res.size() == depth - 1)
            res.add(node.val);
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
