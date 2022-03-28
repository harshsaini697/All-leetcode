/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
​
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
​
class Solution {
    public Node copyRandomList(Node head) {
        
        Node dummy = head;
        
        while(dummy != null) {
            //insert a new node after current node
            Node curr = dummy;
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            dummy = dummy.next.next;
        }
        
        dummy = head;
        
        while(dummy != null) {
            Node curr = dummy;
            if(curr.random != null)
                curr.next.random = curr.random.next;
            dummy = dummy.next.next;
        }
        
        dummy = head;
        
        Node result = new Node(0);// 0 -> 7 > 7
        //save the result pointer
        Node res = result;
        //rearrange pointers
        while(dummy != null) {
            result.next = dummy.next;
            dummy.next = dummy.next.next;
            dummy = dummy.next;
            result = result.next;
        }
        
        return res.next;
    }
}
