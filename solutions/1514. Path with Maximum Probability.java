class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        //creating adjaceny list
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            map.computeIfAbsent(a, l -> new ArrayList()).add(new int[]{b, i});
            map.computeIfAbsent(b, l -> new ArrayList()).add(new int[]{a, i});
        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            if(curr == end) {
                return p[end];
            }
            for(int[] i: map.getOrDefault(curr, Collections.emptyList())) {
                int neighbor = i[0];
                int edgeIndex = i[1];
                if(p[curr] * succProb[edgeIndex] > p[neighbor]) {
                    p[neighbor] = p[curr] * succProb[edgeIndex];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
    }
}
