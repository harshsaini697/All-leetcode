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
    ArrayList<Integer> list;
    public int rangeSumBST(TreeNode root, int low, int high) {
        list = new ArrayList<>();
        inorder(root);
        int res = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) >= low && list.get(i)  <= high){
                res += list.get(i);
            }
        }
        return res;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
