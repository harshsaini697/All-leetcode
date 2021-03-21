/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Queue<TreeNode> q = new LinkedList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return new String("");
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr != null){
                sb.append(curr.val);
                sb.append(",");
                q.add(curr.left);
                q.add(curr.right);
            }else{
                sb.append("null");
                sb.append(",");
            }
        }
        return sb.toString();
        
    }
​
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strArr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        int i = 1;
        q.add(root);
        while(!q.isEmpty() && i < strArr.length){
            TreeNode curr = q.poll();
            //left child
            if(strArr[i].equals("null")){
                curr.left = null; 
            }else{
                curr.left = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.left);
            }
            i++;
            //right child
            if(strArr[i].equals("null")){
                curr.right = null; 
            }else{
                curr.right = new TreeNode(Integer.parseInt(strArr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
