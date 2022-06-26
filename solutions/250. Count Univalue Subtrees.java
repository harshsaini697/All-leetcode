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
    int ans = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        checkTrees(root); 
        return ans;
    }
    
    private boolean checkTrees(TreeNode root){
        if(root == null)    return true;
        boolean left = checkTrees(root.left);
        boolean right = checkTrees(root.right);
        //finding uni value subtrees 
        if((left && right) 
            && (root.left == null || root.left.val == root.val)
            && (root.right == null || root.right.val == root.val)){
            ans++;
            return true;
        }
        return false;
    }
}
