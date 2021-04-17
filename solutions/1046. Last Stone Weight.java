class Solution {
    public int lastStoneWeight(int[] stones) {
        int min = Integer.MAX_VALUE;
        if(stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        while(!pq.isEmpty() && pq.size() >= 2){
            int y = pq.poll();
            int x = pq.poll();
            min = Math.min(min, x);
            //System.out.println(y + "  "+x);
            if(x != y){
                pq.add(y-x);
            }
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }
}
