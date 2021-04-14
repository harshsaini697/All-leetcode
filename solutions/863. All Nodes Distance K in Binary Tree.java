/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    List<Integer> ans;
    int K = 0;
    TreeNode target;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        this.target = target;
        this.K = K;
        dfs(root);
        
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(root == null) return -1;
        int index = 0;
        if(root == target){
            subTree(root, 0);
            return 1;
        }else{
            int L = dfs(root.left), R = dfs(root.right);
            if (L != -1) {
                if (L == K) ans.add(root.val);
                subTree(root.right, L + 1);
                return L + 1;
            }else if (R != -1) {
                if (R == K) ans.add(root.val);
                subTree(root.left, R + 1);
                return R + 1;
            }else{
                return -1;
            }
        }
    }
    private void subTree(TreeNode node, int dist){
        if(node == null ) return ;
        if(dist == K){
            ans.add(node.val);
        }else{
            subTree(node.left,  dist + 1);
            subTree(node.right,  dist + 1);
        }
    }
}
