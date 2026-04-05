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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<TreeNode, int[]> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            boolean isVisited = map.containsKey(node);
            if (!isVisited) {
                stack.push(node);
                map.put(node, null);
                stack.push(node.right);
                stack.push(node.left);
            }
            else {
                int[] leftData = map.getOrDefault(node.left, new int[]{0,0});
                int[] rightData = map.getOrDefault(node.right, new int[]{0, 0});
                map.put(
                    node,
                    new int[]{
                        1 + Math.max(leftData[0], rightData[0]),
                        Math.max(
                            leftData[0] + rightData[0], 
                            Math.max(leftData[1], rightData[1])
                        )
                    }
                );
            }
        }
        return map.get(root)[1];
    }
}
