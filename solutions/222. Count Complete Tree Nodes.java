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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return helper(root);
    }
    
    private int helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int height_left = 1;
        TreeNode node = root;
        // moving condition
        while(node.left != null) {
            node = node.left;
            height_left++;
        }
        //node reset important
        node = root;
        int height_right = 1;
        while(node.right != null) {
            node = node.right;
            height_right++;
        }
        
        if(height_left == height_right) {
            return (int) Math.pow(2, height_left) - 1;
        } else {
            return helper(root.left) + helper(root.right) + 1;
        }
    }
}
