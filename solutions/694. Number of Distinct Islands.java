class Solution {
    private int max = 0;
    // int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, visited, i , j , sb, "o");
                    set.add(sb.toString());
                    System.out.println(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, boolean[][] visited, int i, int j, StringBuilder sb, String p){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0 ){
            return;
        }
        sb.append(p);
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j, sb, "u");
        dfs(grid, visited, i + 1, j, sb, "d");
        dfs(grid, visited, i, j - 1, sb, "l");
        dfs(grid, visited, i, j + 1, sb, "r");
        sb.append("b");
    }
}
