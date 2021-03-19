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
public class Solution {
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }
    
    private void preorder(TreeNode node, int currsum) {
        if(node == null) return;
        
        currsum += node.val;
        if(currsum == k) count++;
        count += h.getOrDefault(currsum - k, 0);
        h.put(currsum, h.getOrDefault(currsum, 0) + 1);
        preorder(node.left, currsum);
        preorder(node.right, currsum);
        h.put(currsum, h.get(currsum) - 1);
    }
}
