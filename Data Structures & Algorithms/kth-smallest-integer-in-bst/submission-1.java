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
    // recursive dfs (no early termination)
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        dfs(root, sortedList);
        return sortedList.get(k-1);
    }

    private void dfs(TreeNode node, List<Integer> sortedList) {
        if (node == null)
            return ;
        dfs(node.left, sortedList);
        sortedList.add(node.val);
        dfs(node.right, sortedList);
    }
}
