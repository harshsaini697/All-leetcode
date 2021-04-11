class MyHashSet {
    int[][] nodes;
    /** Initialize your data structure here. */
    public MyHashSet() {
        nodes = new int[1001][1001];
        for(int i = 0; i < nodes.length; i++){
            Arrays.fill(nodes[i], -1);
        }
    }
    
    public void add(int key) {
        int col = key % 1000;
        int row = key / 1000;
        nodes[row][col] = key;
    }
    
    public void remove(int key) {
        int col = key % 1000;
        int row = key / 1000;
        nodes[row][col] = -1;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int col = key % 1000;
        int row = key / 1000;
        return nodes[row][col] != -1;
    }
}
​
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
