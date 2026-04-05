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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{p, q});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode[] pair = queue.poll();
                TreeNode n1 = pair[0], n2 = pair[1];
                if (n1 == null && n2 == null)
                    continue;
                else if (n1 == null || n2 == null || n1.val != n2.val)
                    return false;

                queue.offer(new TreeNode[]{n1.left, n2.left});
                queue.offer(new TreeNode[]{n1.right, n2.right});
            }
        }
        return true;
    }
}
