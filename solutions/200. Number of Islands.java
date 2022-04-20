class Solution {
    int result = 0;
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        // base
        if(x >= grid.length || y >= grid[0].length || x < 0 || y < 0) {
            return;
        }
        if(grid[x][y] != '1') {
            return;
        }
        
        //recurse
        for(int i = 0; i < dirs.length; i++) {
            int m = dirs[i][0] + x;
            int n = dirs[i][1] + y;
            grid[x][y] = '0'; 
            dfs(grid, m, n);
        }
        
    }
}
