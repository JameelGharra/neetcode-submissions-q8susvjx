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
    //dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int depth) {
        if (node == null)
            return;
        if (list.size() == depth)
            list.add(new ArrayList<>());
        list.get(depth).add(node.val);
        dfs(node.left, list, depth + 1);
        dfs(node.right, list, depth + 1);
    }
}
