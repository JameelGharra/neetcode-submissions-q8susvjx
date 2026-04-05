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
    private int preIdx;
    private Map<Integer, Integer> valToInIdx;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        valToInIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            valToInIdx.put(inorder[i], i);
        return dfs(preorder, 0, preorder.length - 1);
    }
    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int rootInIdx = valToInIdx.get(preorder[preIdx]);
        TreeNode rootNode = new TreeNode(preorder[preIdx]);
        preIdx++;
        rootNode.left = dfs(preorder, left, rootInIdx - 1);
        rootNode.right = dfs(preorder, rootInIdx + 1, right);
        return rootNode;
    }
}
