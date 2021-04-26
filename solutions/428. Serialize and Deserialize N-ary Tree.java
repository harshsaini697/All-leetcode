*/
​
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList();
        q.offer(root);
        sb.append(root.val).append(",").append(root.children.size()).append(",");
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node c: curr.children){
                q.add(c);
                sb.append(c.val).append(",").append(c.children.size()).append(",");   
            }
        }
        //System.out.println(sb);
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> childQueue = new LinkedList<Integer>();
        Node root = new Node(Integer.valueOf(nodes[0]));
        queue.offer(root);
        childQueue.offer(Integer.valueOf(nodes[1]));
        int i = 2;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.children = new ArrayList<>();
            int n = childQueue.poll();
            for (int j = 0; j < n; j++) {
                Node child = new Node(Integer.valueOf(nodes[i++]));
                childQueue.offer(Integer.valueOf(nodes[i++]));
                queue.offer(child);
                cur.children.add(child);
            }
        }
        return root;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
