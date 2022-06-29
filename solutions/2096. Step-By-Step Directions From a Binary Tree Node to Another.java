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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null || startValue == destValue) return "";
        
        TreeNode currLCA = getLowestCommonAncestor(root, startValue, destValue);
        StringBuilder lcaToStart = new StringBuilder();
        StringBuilder lcaToEnd = new StringBuilder();
        
        traverse(currLCA, startValue, lcaToStart);
        traverse(currLCA, destValue, lcaToEnd);
        
        String s = "U";
        s = s.repeat(lcaToStart.length());
        return s + lcaToEnd.toString();
    }
    
    private boolean traverse(TreeNode start, int dest, StringBuilder sb) {
        if(start == null) return false;
        
        if(start.val == dest) 
            return true;
        
        sb.append('L');
        
        if(traverse(start.left, dest, sb)) 
            return true;
        
        sb.setCharAt(sb.length() - 1, 'R');
        
        if(traverse(start.right, dest, sb)) 
