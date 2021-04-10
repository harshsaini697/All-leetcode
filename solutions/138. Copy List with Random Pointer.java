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
        // 1. Create New Nodes
        // 2. Configure random pointers
        // 3. Split the nodes
        if(head == null) return null;
        
        Node curr = head;
        while(curr != null){
            Node currCopy = new Node(curr.val);
            Node temp = curr.next;
            curr.next = currCopy;
            currCopy.next = temp;
            curr = curr.next.next; // move next twice
        }
        //Step 2 random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Step 3 split
        curr = head;
        Node copyHead = curr.next;
        Node currCopy = copyHead;
        while(curr != null){
            curr.next = curr.next.next;
            if(currCopy.next != null){
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next;
            currCopy = currCopy.next;    
        }
        return copyHead;
    }
}
