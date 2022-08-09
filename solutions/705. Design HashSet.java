class MyHashSet {
    boolean[][] hashSet;
    int buckets = 1001;
    public MyHashSet() {
        hashSet = new boolean[buckets][];
    }
    private int hash1(int key) {
        return key % (buckets);
    }
    
    private int hash2(int key) {
        return key / buckets;
    }
    
    public void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(hashSet[index1] == null) {
            hashSet[index1] = new boolean[buckets + 1];
        }
        hashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(hashSet[index1] != null) { 
            hashSet[index1][index2] = false;
        }
    }
    
    public boolean contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        return hashSet[index1] == null || hashSet[index1][index2] == false ? false : true;
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
