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
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList();
        if(root == null) return result;
        
        while(root != null) {
            List<Integer> children = new ArrayList<>();
            root = dfsRemoveLeafs(root, children);
            result.add(children);
        }
        return result;
    }
    
    private TreeNode dfsRemoveLeafs(TreeNode node, List<Integer> children) {
        if(node == null) return null;
        if(node.left == null && node.right == null) {
            children.add(node.val);
            return null;
        }
        
        node.left = dfsRemoveLeafs(node.left, children);
        node.right = dfsRemoveLeafs(node.right, children);
        return node;
    }
    
    
}
