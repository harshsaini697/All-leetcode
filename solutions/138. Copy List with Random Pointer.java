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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node currCopy = copyHead;
        while(curr != null){
            // Check if random exists
            currCopy.random = clone(curr.random);
            currCopy.next = clone(curr.next);
            currCopy = currCopy.next;
            curr = curr.next;
        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node temp = new Node(node.val);
            map.put(node, temp);
        }
        return map.get(node);
    }
    
   
}
