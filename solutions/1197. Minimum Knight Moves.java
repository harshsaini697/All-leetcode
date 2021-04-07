class Solution {
    int[][] dirs = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        if(x == 0 && y == 0 ) return 0;
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int count = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] curr = q.poll();
                
                if(curr[0] == x && curr[1] == y){
                    return count;
                }
                for(int[] dir: dirs){
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if( !visited.contains(i + "," + j) && i >= -1 && j >= -1 ){
                        q.add(new int[]{i, j});
                        visited.add(i + "," + j);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
