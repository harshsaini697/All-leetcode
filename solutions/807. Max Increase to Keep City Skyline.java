class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] side = new int[n];
        int[] top = new int[m];
        
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < m; j++){
                max = Math.max(grid[i][j], max);
            }
            side[i] = max;
        }
        
        for(int j = 0; j < m; j++){
            int max = 0;
            for(int i = 0; i < n; i++){
                max = Math.max(grid[i][j], max);
            }
            top[j] = max;
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result += Math.min(side[i], top[j]) - grid[i][j];
            }
        }
        return result;
    }
}
