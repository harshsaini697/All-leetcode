class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        //building adjList
        for(int i = 0; i < prerequisites.length; i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            
            if(!adjList.containsKey(src)){
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add(dest);
            indegree[dest]++;
        }
        
        //indgree
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        int[] res = new int[numCourses];
        int k = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            res[k++] = curr;
            if (adjList.containsKey(curr)) {
                for(Integer d: adjList.get(curr)){
                    indegree[d] -= 1;
                    if(indegree[d] == 0){
                        q.add(d);
                    }
                }
            }
        }
        if(k == numCourses){
            return res;
        }
        return new int[0];
    }
}
