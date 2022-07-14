class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean flag = false;
        if(!map.containsKey(val)) {
            map.put(val, new HashSet());
            flag = true;
        }
        int index = list.size();
        list.add(index, val);
        map.get(val).add(index);
        return flag;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        int newVal = list.get(list.size() - 1);
        list.set(index, newVal);
        map.get(newVal).add(index);
        map.get(newVal).remove(list.size() - 1);
        list.remove(list.size() - 1);
        if(map.get(val).size() == 0) map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
​
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
