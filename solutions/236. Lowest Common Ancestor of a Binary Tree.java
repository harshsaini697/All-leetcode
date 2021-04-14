/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root  == null) return root;
        res = null;
        dfs(root, p, q);
        return res;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p ,q) ? 1: 0;
        
        int mid = 0;
        if(root.val == p.val || root.val == q.val){
            mid = 1;
        }
        
        if(left + right + mid >= 2){
            res = root;
            return true;
        }
        return (left + right + mid >= 1);
    }
}
