class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        if(heights == null || heights.length == 0) return 0;
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int d = curr[0], r = curr[1], c = curr[2];
            if (r == m - 1 && c == n - 1) return d;
            
            for(int i = 0; i < dirs.length; i++) {
                int x = dirs[i][0] + r;
                int y = dirs[i][1] + c;
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int newDist = Math.max(d, Math.abs(heights[x][y] - heights[r][c]));
                    if(dist[x][y] > newDist) {
                        dist[x][y] = newDist;
                        minHeap.offer(new int[]{dist[x][y], x, y});
                    }
                    
                }
            }
        }
        return 0;
    }
}
