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
    HashMap<Integer, Integer> map;
    int res = 0;
    int k;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        map = new HashMap<>();
        k = targetSum;
        preorder(root, 0);
        map.put(0,1);
        return res;
    }
    private void preorder(TreeNode node, int sum){
        if(node == null) return;
        
        sum += node.val;
        if(sum == k){
            res++;
        }
        res += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        preorder(node.left, sum);
        preorder(node.right, sum);
        
        map.put(sum, map.get(sum) - 1);
    }
}
