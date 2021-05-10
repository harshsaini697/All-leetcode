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
            map.put(key, curr);
            addToHead(curr);
        }else{
            Node curr = map.get(key);
            curr.value = value;
            removeNode(curr);
            addToHead(curr);
        }
    }
}
​
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
