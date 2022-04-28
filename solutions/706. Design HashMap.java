class MyHashMap {
    ListNode[] nodes;
    public MyHashMap() {
        nodes = new ListNode[1000];
    }
    
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null) {
            nodes[index] = new ListNode(-1, -1);
        }
        ListNode prev = find(nodes[index], key);
        
        if(prev.next == null)
            prev.next = new ListNode(key, value);
        else 
            prev.next.val = value;
    }
    
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null) return -1;
        ListNode prev = find(nodes[index], key);
        return prev.next == null? -1 : prev.next.val;
    }
    
    public void remove(int key) {
        int index = index(key);
        ListNode prev = find(nodes[index], key);
        if(prev != null) {
            if(prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }
    
    private int index(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    
    private ListNode find(ListNode bucket, int key){
        ListNode node = bucket, prev = null;
        for(; node != null && node.key != key; node = node.next)
            prev = node;
        return prev;
    }
}
​
class ListNode {
    int key, val;
    ListNode next;
​
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
​
/**
