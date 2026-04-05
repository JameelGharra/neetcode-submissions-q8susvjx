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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String serializedRoot = serializedTree(root, new StringBuilder()).toString();
        String serializedSubRoot = serializedTree(subRoot, new StringBuilder()).toString();
        String combined = serializedSubRoot + '|' + serializedRoot;
        
        int[] zValues = zFunction(combined);
        int afterSeparatorIdx = serializedSubRoot.length()+1; // after separator '|'

        for (int i = afterSeparatorIdx; i < combined.length(); ++i) {
            if (zValues[i] == afterSeparatorIdx-1) {
                return true;
            }
        }
        return false;
    }
    private int[] zFunction(String s) {
        int l = 0, r = 0, n = s.length();
        int[] z = new int[n];
        for (int i = 1; i < n; ++i) {
            if (i > r) {
                l = i;
                r = i;
                while (r < n && s.charAt(r-l) == s.charAt(r))
                    r++;
                z[i] = r-l;
                r--;
            }
            else {
                int c = i - l;
                if (z[c] < r - i + 1) {
                    z[i] = z[c];
                }
                else {
                    l = i;
                    while (r < n && s.charAt(r-l) == s.charAt(r))
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }
    private StringBuilder serializedTree(TreeNode node, StringBuilder builder) {
        if (node == null) {
            return builder.append("$").append("#");
        }
        builder.append("$").append(node.val);
        serializedTree(node.left, builder);
        serializedTree(node.right, builder);
        return builder;
    }
}
