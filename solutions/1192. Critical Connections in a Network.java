class Solution {
    HashMap<Integer, List<Integer>> map;
    int time = 0;
    List<List<Integer>> result;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        result = new ArrayList<>();
        if(connections == null || connections.size() == 0) return result;
        map = new HashMap<>();
        buildgraph(connections);
        int[] discovery = new int[map.size()];
        Arrays.fill(discovery, -1);
        int[] lowest = new int[map.size()];
        dfs(0, 0, discovery, lowest);
        return result;
    }
    
    private void dfs(int v, int p, int[] discovery,int[] lowest){
        if(discovery[v] != -1) return;
        discovery[v] = time;
        lowest[v] = time++;
        for(Integer n: map.get(v)){
            if(n == p) continue;
            dfs(n, v, discovery, lowest);
            if(lowest[n] > discovery[v]){
                result.add(Arrays.asList(n,v));
            }
            lowest[v] = Math.min(lowest[n], lowest[v]);
        }
    }
    
    private void buildgraph(List<List<Integer>> connections){
        for(List<Integer> edge: connections){
            map.putIfAbsent(edge.get(0), new ArrayList<>());
            map.putIfAbsent(edge.get(1), new ArrayList<>());
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(1)).add(edge.get(0));
        }
    }
}
