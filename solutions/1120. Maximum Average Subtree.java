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
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        post(root);
        return post(root).avg;
    }
    private Pair post(TreeNode root){
        if(root == null) return new Pair(0,0,0);
        
        Pair left = post(root.left);
        
        //double left_avg = left.sum / left.n == 0 ? 1 : left.n;
        //res = Math.max(left_avg, res);
        Pair right = post(root.right);
        //double right_avg = right.sum / right.n == 0 ? 1 : right.n;
        //res = Math.max(right_avg, res);
        int sum = root.val + left.sum + right.sum;
        int nodeCount = left.n + right.n + 1;
        //res = Math.max(root.val, res);
        double maxAverage = Math.max(
                (1.0 * (sum)) / nodeCount, // average for current node
                Math.max(right.avg, left.avg) // max average from child nodes
        );
        return new Pair(sum, nodeCount, maxAverage);
        
    }
}
​
class Pair{
    int sum;
    int n;
    double avg;
    Pair(int sum, int n, double avg){
        this.sum = sum;
        this.n = n;
        this.avg = avg;
    }
}
