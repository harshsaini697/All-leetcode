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
    private String leftChild = "L";
    private String rightChild = "R";
    private String parentNode = "U";
    TreeNode startNode = null;
    TreeNode endNode = null;
    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    //HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null) {
            return "";
        }
        parentMap.put(root.val, null);
        
        Stack<Pair<TreeNode, TreeNode>> st = new Stack<>();
        TreeNode node = root;
        TreeNode par = null;
        parentMap.put(root.val, null);
        while(node != null || !st.isEmpty()) {
            while(node != null) {
                st.push(new Pair(node, par));
                par = node;
                node = node.left;
            }
            Pair temp = st.pop();
            node = (TreeNode)temp.getKey();
            par = (TreeNode)temp.getValue();
            parentMap.put(node.val, par);
            if (node.val == startValue) {
                //System.out.println(node.val);
                startNode = node;
            } else if (node.val == destValue) {
                //System.out.println(node.val);
                endNode = node;
            }
            par = node;
            node = node.right;
        }
​
        if(startNode == null || endNode == null) return "NP";
        Queue<Pair<TreeNode, String>> q = new LinkedList();
        q.add(new Pair(startNode, ""));
        Set<Integer> visited = new HashSet<>();
        StringBuilder path = new StringBuilder();
        while(!q.isEmpty()) {
            Pair temp = q.poll();
            TreeNode curr = (TreeNode)temp.getKey();
            String currString = (String)temp.getValue();
            visited.add(curr.val);
            if(curr.val == destValue) return currString;
            TreeNode parent = parentMap.get(curr.val);
            if(parent != null && !visited.contains(parent.val)) {
                q.add(new Pair(parent, currString + "U"));
            }
            if(curr.left != null && !visited.contains(curr.left.val)) {
                q.add(new Pair(curr.left, currString + "L"));
            }
            if(curr.right != null && !visited.contains(curr.right.val)) {
                q.add(new Pair(curr.right, currString + "R"));
            }
        }
        return "";
    }
}
