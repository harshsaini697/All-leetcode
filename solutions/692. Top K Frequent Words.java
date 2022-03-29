class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // we need to do bucket sort
        
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            max = Math.max(max, map.get(words[i]));
        }
        
        //buckets
        List<String>[] bucket = new ArrayList[max + 1];
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(entry.getKey());
        }
        
        List<String> res = new ArrayList<>();
        // start searching from the end of bucket to find all the elements and terminate loop when res reaches the desired amount.
        for(int i = max; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null) {
                Collections.sort(bucket[i]);
                res.addAll(bucket[i]);
            }
        }
        
        return res.subList(0, k);
    }
}
