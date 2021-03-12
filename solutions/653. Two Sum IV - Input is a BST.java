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
    List<Integer> elements;
    public boolean findTarget(TreeNode root, int k) {
        elements = new ArrayList<>();
        getElements(root);
        int l = 0, r = elements.size() - 1;
        while(l < r){
            int sum = elements.get(l) + elements.get(r);
            if(sum == k) return true;
            else if(sum < k) 
                l++;
            else
                r--;
        }
        return false;
        
    }
    private void getElements(TreeNode root){
        if(root == null) return;
        
        getElements(root.left);
        elements.add(root.val);
        getElements(root.right);
        
    }
}
