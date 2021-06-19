/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
​
    public Node() {}
​
    public Node(int _val) {
        val = _val;
    }
​
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
​
class Solution {
    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        if(root == null) return res;
//         Stack<Node> st = new Stack<>();
//         st.push(root);
        
//         while(!st.isEmpty()){
//             root = st.pop();
//             res.add(root.val);
//             for(int k = root.children.size() - 1; k >= 0; k--){ //adding from back to make sure reverse order turns out
//                 st.push(root.children.get(k));
//             } 
//         }
        pre(root);
        return res;
    }
    
    private void pre(Node root){
        if(root == null) return;
        res.add(root.val);
        for(int k = 0; k < root.children.size() ; k++){
            pre(root.children.get(k));
        }
    }
}
