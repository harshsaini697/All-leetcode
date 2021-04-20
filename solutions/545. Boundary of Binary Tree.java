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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        leftView(root.left);
        bottomView(root.left);
        bottomView(root.right);
        //bottomView(root.right);
        rightView(root.right);
        return result;
    }
    private void leftView(TreeNode root){ // preorder
        if(root == null ||(root.left == null && root.right == null)) return;
        result.add(root.val);
        if(root.left == null) leftView(root.right);
        else leftView(root.left);
    }
    private void rightView(TreeNode root){ // postorder
        if(root == null||(root.left == null && root.right == null)) return;
        if(root.right == null) rightView(root.left);
        else rightView(root.right);
        result.add(root.val);
    }
    private void bottomView(TreeNode root){ // inorder
        if(root == null) return;
        bottomView(root.left);
        if(root.left == null && root.right == null){//leaf node
            result.add(root.val);
            return;
        }
        bottomView(root.right);
    }
}
