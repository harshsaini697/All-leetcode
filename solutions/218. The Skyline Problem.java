class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> heights = new ArrayList<>();
        for(int[] b: buildings){
            heights.add(Arrays.asList(b[0], -b[2])); // starting point we can put height as negative
            heights.add(Arrays.asList(b[1], b[2])); // ending point
        }
        Collections.sort(heights, (a,b) -> {
            if(a.get(0) != b.get(0))
                return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        pq.offer(0);
        int curr = 0;
        for(List<Integer> h: heights){
            if(h.get(1) < 0){// starting index
                pq.offer(-h.get(1));
            }else{
                pq.remove(h.get(1));
            }
            if(curr != pq.peek()){
                curr = pq.peek();
                result.add(Arrays.asList(h.get(0), curr)); 
            }
        }
        return result;
    }
}
