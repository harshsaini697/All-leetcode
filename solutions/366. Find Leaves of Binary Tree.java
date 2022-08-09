class Solution {
    private List<List<Integer>> result;
    
    private int getHeight(TreeNode root) {
        // return -1 for null nodes
        if (root == null) {
            return -1;
        }
        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left); // 1
        int rightHeight = getHeight(root.right); // 0
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1; // 2
        
        if (this.result.size() == currHeight) { 
            this.result.add(new ArrayList<>());// [[4,5,3],[2],[]]
        }
        this.result.get(currHeight).add(root.val); //[[4,5,3], [2], [1]]
        return currHeight;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.result = new ArrayList<>();
        getHeight(root);
        return this.result;
    }
}
