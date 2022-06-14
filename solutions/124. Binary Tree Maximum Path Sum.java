/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        this.maxValue = Integer.MIN_VALUE;
        if(root == null) return 0;
        findMaxPath(root);
        return maxValue;
    }
    
    private int findMaxPath(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));
        maxValue = Math.max(maxValue, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
