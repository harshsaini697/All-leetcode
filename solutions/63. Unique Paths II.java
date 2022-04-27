class Solution {
    int max = 0;
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        //base 
        if(grid == null || grid.length == 0) return 0;
        dp = new Integer[grid.length][grid[0].length];
        
        return recurse(grid, 0, 0);
    }
    // bottom 0, right 1
    private int recurse(int[][] grid, int i, int j ) {
        // base check if obstacle, return 0;
        if(i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        
        if(grid[i][j] == 1) {
            return 0;
        }
        
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        //recurse 
        
        int case1 =  recurse(grid, i + 1, j);
        int case2 = recurse(grid, i, j + 1);
        return dp[i][j] = Math.max(case1 + case2, max);
    }
}
