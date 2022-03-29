class MinStack {
    private Node head;
    
    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, val);
        } else {
            Node temp = new Node(val, Math.min(val, head.min), head);
            head = temp;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
​
class Node {
    int val;
    int min;
    Node next;
    
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
    
    Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
​
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
