class FileSystem {
    Map<String, Integer> files;
    public FileSystem() {
        files = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.isEmpty() || 
           (path.length() == 1 && path.equals("/")) || 
           files.containsKey(path)) {
            return false;
        }
        int delimIndex = path.lastIndexOf("/");
        String parent = path.substring(0, delimIndex);
        
        //check if parent exists in map or not
        if(parent.length() > 1 && !files.containsKey(parent)) {
            return false;
        }
        // add path to files
        files.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return files.getOrDefault(path, -1);
    }
}
​
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
