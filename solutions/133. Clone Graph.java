/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
​
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node node) {
        //base
        if(map.containsKey(node)) return;
        
        //running
        Node curr = new Node(node.val);
        map.put(node, curr);
        for(Node n: node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}
