class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null) {
            return false;
        }
        
        // build adjacency list
        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        
        for(int v = 0; v < n; v++) {
            adjMap.put(v, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adjMap.get(edge[0]).add(edge[1]);
            adjMap.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        return checkIsTree(adjMap, n, visited);
        
    }
    
    private boolean checkCycles(Map<Integer, List<Integer>> adjMap, int vertex, int parent, boolean[] visited ) {
        
        visited[vertex] = true;
        
        for(Integer adjacentNode: adjMap.get(vertex)) {
            if(!visited[adjacentNode]) {
                checkCycles(adjMap, adjacentNode, vertex, visited);
            } 
            else if (adjacentNode != parent) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkIsTree(Map<Integer, List<Integer>> adjMap, int n, boolean[] visited) {
        
        if(checkCycles(adjMap, 0, -1, visited)) {
            return false;
        }
        
        for(int u = 0; u < n; u++) {
            if(!visited[u]) {
                return false;
            }
        }
