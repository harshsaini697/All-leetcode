class RandomizedSet {
    List<Integer> numList;
    Map<Integer, Integer> indexMap;
    Random rand; 
    public RandomizedSet() {
        numList = new ArrayList();
        indexMap = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!indexMap.containsKey(val)) {
            int index = numList.size();
            numList.add(index, val);
            indexMap.put(val, numList.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(indexMap.containsKey(val)) {
            int index = indexMap.get(val);
            int newVal = numList.get(numList.size() - 1);
            numList.set(index, newVal);
            numList.remove(numList.size() - 1);
            indexMap.put(newVal, index);
            indexMap.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return numList.get(rand.nextInt(numList.size()));
    }
}
​
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
