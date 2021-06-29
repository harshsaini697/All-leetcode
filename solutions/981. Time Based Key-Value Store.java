class TimeMap {
    HashMap<String, Node> map;
    Node head;
    /** Initialize your data structure here. */
    public TimeMap() {
        head = new Node("", 0, 0);
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new Node(value, timestamp, timestamp));
        }else{
            Node temp = map.get(key);
            if(temp.max < timestamp){
                Node node = new Node(value, timestamp, timestamp);
                node.next = temp;
                map.put(key, node);
            }else{
                while(temp.next != null){
                    if(temp.next.max < timestamp){
                        Node node = new Node(value, timestamp, timestamp);
                        Node next = temp.next;
                        temp.next = node;
                        node.next = next;
                        break;
                    }else{
                        temp = temp.next;
                    }
                }
            }
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }else{
            Node node = map.get(key);
            if(node.timestamp <= timestamp){
                return node.value;
            }else{
                while(node != null){
                    Node temp = node;
                    if(temp.timestamp <= timestamp){
                        return temp.value;
                    }else{
                        node = node.next;
                    }
                }
            }
        }
