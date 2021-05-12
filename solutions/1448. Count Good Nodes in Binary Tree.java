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
    int count;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        count = 0;
        return dfs(root, root.val);
    }
    private int dfs(TreeNode root, int max){
        if(root == null) return 0;
        if(root.val >= max){
            count +=1;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
        return count;
    }
}
