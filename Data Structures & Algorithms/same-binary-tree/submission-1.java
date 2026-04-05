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

// iterative
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> nodes1 = new Stack<>();
        Stack<TreeNode> nodes2 = new Stack<>();
        nodes1.push(p);
        nodes2.push(q);
        while (!nodes1.isEmpty() && !nodes2.isEmpty()) {
            TreeNode node1 = nodes1.pop();
            TreeNode node2 = nodes2.pop();
            if (node1 == null && node2 != null || node1 != null && node2 == null)
                return false;
            if (node1 == null && node2 == null)
                continue;
            if (node1.val != node2.val)
                return false;
            nodes1.push(node1.left);
            nodes1.push(node1.right);
            nodes2.push(node2.left);
            nodes2.push(node2.right);
        }
        return nodes1.isEmpty() && nodes2.isEmpty();
    }
}
