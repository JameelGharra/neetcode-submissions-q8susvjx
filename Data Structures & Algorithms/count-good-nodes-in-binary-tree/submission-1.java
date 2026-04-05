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
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new Pair<>(root, root.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode curr = pair.getKey();
                int currMax = pair.getValue();
                if (curr.val >= currMax)
                    ++count;
                currMax = Math.max(currMax, curr.val);
                if (curr.left != null) queue.offer(new Pair<>(curr.left, currMax));
                if (curr.right != null) queue.offer(new Pair<>(curr.right, currMax));
            }
        }
        return count;
    }
}
