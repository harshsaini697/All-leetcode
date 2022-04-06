    }
};
*/
​
class Solution {
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node prev = null;
        Node head = root;
        Stack<Node> st = new Stack<>();
        Node dummy = root;
        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            if(prev == null) {
                head = root;
            } else {
                prev.right = root;
                root.left = prev;
            }
            
            prev = root;
            root = root.right;
        }
        prev.right = head;
        head.left = prev;
        return head;
    }
}
​
