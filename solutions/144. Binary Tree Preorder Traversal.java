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
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //preorder(root);
        //iterative
        
        Stack<TreeNode> st = new Stack();
        while(root != null || !st.isEmpty()){
            while(root != null){
                res.add(root.val);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
    //recursive
    // private void preorder(TreeNode root){
    //     if(root == null) return;
    //     res.add(root.val);
    //     preorderTraversal(root.left);
    //     preorderTraversal(root.right);
    // }
}
