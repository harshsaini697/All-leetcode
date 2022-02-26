class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(count::get));
        pq.addAll(count.keySet());
        while(k > 0) {
            k -= count.get(pq.poll());
        }
        return k < 0 ? pq.size() + 1 : pq.size();
    }
    
    
}
