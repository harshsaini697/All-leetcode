class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
    public boolean containsCycle(char[][] grid) {
        if(grid == null || grid.length == 0) return false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean hasCycle = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited, i, j, -1, -1, grid[i][j])) return true;
                }
            }
        }
        return hasCycle;
    }
    private boolean dfs(char[][] grid, boolean[][] visited, int currX, int currY, int lastX, int lastY, char lastChar){
        visited[currX][currY] = true;
        boolean hasCycle = false;
        //dfs
        for(int[] dir: dirs){
            int newI = currX + dir[0];
            int newJ = currY + dir[1];
            if(newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length){
                if(!(newI == lastX && newJ == lastY) ){
                    if(grid[newI][newJ] == lastChar){
                        if(visited[newI][newJ] ){
                            return true;
                        }else{
                            hasCycle |= dfs(grid, visited, newI, newJ, currX, currY, lastChar);
                        }
                    }
                }
            }
        }
        return hasCycle;
    }
}
