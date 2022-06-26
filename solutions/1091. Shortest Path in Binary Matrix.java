class Solution {
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        Queue<int[]> q = new LinkedList();
        q.offer(new int[] {0, 0});
        grid[0][0] = 1;
        int pathLen = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if(curr[0] == n - 1 && curr[1] == n - 1) {
                      return pathLen + 1;
                }
                for(int j = 0; j < dirs.length; j++) {
                    int x = dirs[j][0] + curr[0];
                    int y = dirs[j][1] + curr[1];
                    if(x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 1) {
                        q.offer(new int[] {x , y});
                        grid[x][y] = 1;
                    }
                } 
            }
            pathLen++;
        }
        return -1;
    }
}
