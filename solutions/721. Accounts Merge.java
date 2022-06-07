class Solution {
    public List<List<String>> accountsMerge(List<List<String>> account) {
        if(account == null || account.size() == 0) return account;
        
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        // step 1: building adjacency graph
        for(int i = 0; i < account.size(); i++) {
            String name = account.get(i).get(0);
            for(int j = 1; j < account.get(i).size(); j++) {
                graph.putIfAbsent(account.get(i).get(j), new HashSet<>());
                emailToName.put(account.get(i).get(j), name);
            
                if (j != 1) {
                    graph.get(account.get(i).get(j)).add(account.get(i).get(j - 1));
                    graph.get(account.get(i).get(j - 1)).add(account.get(i).get(j));
                }
            }
        }
        //System.out.println(graph);
        // step 2: do dfs
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> newList = new ArrayList<>();
                dfs(newList, graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(newList.get(0)));
                result.add(newList);
            }
        }
        return result;
    }
    
    public void dfs(List<String> result, Map<String, Set<String>> graph, Set<String> visited, String curPoint) {
        result.add(curPoint);
        Set<String> neighbors = graph.get(curPoint);
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(result, graph, visited, neighbor);
            }
        }
    }
}
​
