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
    List<Integer> result;
    int maxlevel;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        inorder(root, 1);
        return result;
    }
    private void inorder(TreeNode root, int level){
        if(root == null) return;
        
        if(maxlevel < level){
            result.add(root.val);
            maxlevel = level;
        }
        inorder(root.right, level + 1);
        inorder(root.left, level + 1);
    }
}
