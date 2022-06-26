class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c: word.toCharArray()) {
            if(!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c: word.toCharArray()) {
            if(!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c: prefix.toCharArray()) {
            if(!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
}
​
class Node {
    boolean endofWord;
    Map<Character, Node> map;
    public Node() {
        map = new HashMap<Character, Node>();
    }
    public void put(char c, Node node) {
        map.put(c, node);
    }
