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
        String treeStr = serializedTree(root, new StringBuilder()).toString();
        String subStr = serializedTree(subRoot, new StringBuilder()).toString();
        String combined = subStr + '|' + treeStr;

        int totalLen = combined.length(), subLen = subStr.length();
        int[] z = new int[totalLen];
        int l = 0, r = 0;

        for (int i = 1; i < totalLen; ++i) {
            if (i > r) {
                l = i;
                r = i;
                while (r < totalLen && combined.charAt(r - l) == combined.charAt(r))
                    ++r;
                z[i] = r - l;
                --r;
            }
            else {
                if (i + z[i - l] - 1 >= r) {
                    l = i;
                    r = i;
                    while (r < totalLen && combined.charAt(r - l) == combined.charAt(r))
                        ++r;
                    z[i] = r - l;
                    --r;
                }
                else {
                    z[i] = z[r - l];
                }
            }
            if (z[i] == subLen)
                return true;
        }
        return false;
    }

    private StringBuilder serializedTree(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return sb.append("$#");
        }
        sb.append("$").append(node.val);
        serializedTree(node.left, sb);
        serializedTree(node.right, sb);
        return sb;
    }
}
