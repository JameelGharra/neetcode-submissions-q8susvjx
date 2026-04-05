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

// iterative dfs
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<Integer, TreeNode>> stack = new Stack<>();
        stack.push(new Pair<>(1, root));
        int res = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, TreeNode> pair = stack.pop();
            TreeNode node = pair.getValue();
            int depth = pair.getKey();
            res = Math.max(res, depth);
            if (node.left != null) stack.push(new Pair<>(depth + 1, node.left));
            if (node.right != null) stack.push(new Pair<>(depth + 1, node.right));
        }
        return res;
    }
}
