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
    // bfs
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{ root, Long.MIN_VALUE, Long.MAX_VALUE });
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Object[] data = queue.poll();
                TreeNode curr = (TreeNode)data[0];
                long leftBound = (Long)data[1];
                long rightBound = (Long)data[2];
                if (curr.val <= leftBound || curr.val >= rightBound)
                    return false;
                if (curr.left != null)
                    queue.offer(new Object[] { curr.left, leftBound, (long)curr.val });
                if (curr.right != null)
                    queue.offer(new Object[] { curr.right, (long)curr.val, rightBound });
            }
        }
        return true;
    }
}
