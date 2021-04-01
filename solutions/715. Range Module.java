        Integer start = map.floorKey(left);
        if (start == null) return false;
        return map.get(start) >= right;
    }
    
    //10,20
    //2, 9
    //20,29
​
    public void removeRange(int left, int right) {
        if(left >= right) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        //10,29 
        //2 ,9
        //24,28
        // 28, 29
        // 10, 24
        if(end != null && map.get(end) > right){
            map.put(right, map.get(end));
        }
        if(start != null && map.get(start) > left){
            map.put(start, left);
        }
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        //System.out.println("Set after removal left:" + left + " right:" + right + " "+set);
        map.keySet().removeAll(set); 
        //System.out.println(map);
    }
}
​
/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
