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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()){
            root = st.pop();
            res.add(root.val);
            for(int k = root.children.size() - 1; k >= 0; k--){ //adding from back to make sure reverse order turns out
                st.push(root.children.get(k));
            } 
        }
        return res;
    }
}
