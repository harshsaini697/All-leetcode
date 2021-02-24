class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    
    public LRUCache(int cap) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        capacity = cap;
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            
            // //remove from back 
            removeNode(curr);
            //add to head
            addToHead(curr);
            return curr.value;
        }
       return -1; 
    }
    private void removeNode(Node curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }
    
    private void addToHead(Node curr){
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(map.size() == capacity){
                Node r = tail.prev;
                removeNode(r);
                map.remove(r.key);
            }
            Node curr = new Node(key, value);
