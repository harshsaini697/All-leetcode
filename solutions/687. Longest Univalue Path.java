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
​
class Solution {
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return len;
        postorder(root, root.val);
        return len;
    }
    private int postorder(TreeNode root, int value){
        if(root == null) return 0;
        int left = postorder(root.left, root.val);
        int right = postorder(root.right, root.val);
        len = Math.max(len, left + right);
        if(value == root.val) return Math.max(left, right) + 1;
        
​
        return 0;
    }
}
