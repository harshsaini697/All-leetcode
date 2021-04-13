class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k < 1) return new int[]{};
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        
        for(Integer num: map.keySet()){
            if(buckets[map.get(num)] == null){
                buckets[map.get(num)] = new ArrayList<>();
            }
            buckets[map.get(num)].add(num);
        }
        k -= 1;
        for(int i = buckets.length - 1; i >= 0 && k >= 0; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size() && k >= 0; j++){
                    res[k--] = buckets[i].get(j);
                }
            }
        }
        return res;
    }
}
