class Solution {
    int max = 0;
    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max ;
    }
    private int dfs(int[][] grid, int i, int j){
      if (i < 0 || j < 0 || i>= grid.length || j >= grid[0].length ||
            grid[i][j] != 1 || visited[i][j]) return 0;
​
        visited[i][j] = true;
        int res = 1;
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            res += dfs(grid, x, y);
        }
        return res;
    }
}
