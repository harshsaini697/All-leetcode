/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
​
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
​
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
​
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node res = root;
        while(root != null){
            Node head = new Node(0);
            Node end = head;
            while(root != null){
                if(root.left != null){
                    end.next = root.left;
                    end = root.left;
                }
                if(root.right != null){
                    end.next = root.right;
                    end = root.right;
                }
                root = root.next;
            }
            root = head.next;
        }
        return res;
    }
}
