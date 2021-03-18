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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if(root == null) return res;
        helper(root, targetSum, new ArrayList<>(), 0);
        return res;
    }
    private void helper(TreeNode root, int targetSum, List<Integer> temp, int tempSum){
        if(root == null) return;
        
        tempSum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(tempSum == targetSum){
                res.add(new ArrayList<>(temp));
            }
        }
        helper(root.left, targetSum, temp, tempSum);
        helper(root.right, targetSum, temp, tempSum);
        temp.remove(temp.size() - 1);
    }
}
