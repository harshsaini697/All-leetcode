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
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> childq = new LinkedList<>();
        Node root = new Node(Integer.valueOf(nodes[0]));
        q.add(root);
        childq.add(Integer.valueOf(nodes[1]));
        int i = 2;
        while(!q.isEmpty()){
            Node curr = q.poll();
            curr.children = new ArrayList<>();
            int size = childq.poll();
            for(int j = 0; j < size; j++){
                Node child = new Node(Integer.valueOf(nodes[i++]));
                int children = Integer.valueOf(nodes[i++]);
                q.add(child);
                childq.add(children);
                curr.children.add(child);
            }
        }
        return root;
    }
}
​
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
