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
    HashMap<Integer, Integer> map ;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        index = 0;
        return helper(0, inorder.length - 1, preorder, inorder);
    }
    private TreeNode helper(int start, int end, int[] pre, int[] in){
        if(start > end){
            return null;
        }
        int rootval = pre[index];
        TreeNode root = new TreeNode(rootval);
        index++;
        root.left = helper(start, map.get(root.val) - 1, pre, in );
        root.right = helper(map.get(root.val) + 1, end, pre, in );
        return root;
    }
}
