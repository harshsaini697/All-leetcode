class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0) return 0;
        visited = new boolean[isConnected.length];
        int count = 0;
        for(int i = 0; i < isConnected.length; i++){
            if (visited[i] == false) {
                dfs(i, isConnected);
                count++;
            }
        }
        return count;
    }
    private void dfs(int index, int[][] adj){
        int count = 0;
        for(int i = 0; i < adj.length; i++){
            if(adj[index][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(i, adj);
            }
        }
    }
}
