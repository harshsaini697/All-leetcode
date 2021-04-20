class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node("/");
    }
    
    public List<String> ls(String path) {
        Node node = traverse(path);
        List<String> res = new ArrayList<>();
        if(node.isFile){
            res.add(node.name);
        }else{
            for(String n : node.children.keySet()){
                res.add(n);
            }
        }
        return res;
    }
    
    public void mkdir(String path) {
        traverse(path);
    }
    
    public void addContentToFile(String path, String content) {
        Node node = traverse(path);
        node.isFile = true;
        node.content.append(content);
    }
    
    public String readContentFromFile(String path) {
        Node node = traverse(path);
        return node.content.toString();
    }
    
    private Node traverse(String path){
        String[] dirs = path.split("/");
        Node curr = root;
        for(int i = 1; i < dirs.length; i++){
            if(!curr.children.containsKey(dirs[i])){
                curr.children.put(dirs[i], new Node(dirs[i]));
            }
            curr = curr.children.get(dirs[i]);
        }
        return curr;
    }
}
class Node
{
    String name;
    boolean isFile;
    Map<String, Node> children;
    StringBuilder content;
    
    public Node(String name)
    {
        this.name = name;
        children = new TreeMap();
        content = new StringBuilder();
    }
    
}
​
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
