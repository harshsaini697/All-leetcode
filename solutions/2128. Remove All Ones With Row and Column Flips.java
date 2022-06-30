class Solution {
   public boolean removeOnes(int[][] g) {
      int m = g.length, n = g[0].length;
      
      IntStream.range(0,n).forEach(j -> {
         if (g[0][j] == 1) flipColumn(j,g); 
      });
      
      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
             if (g[i][j] != g[i][j-1]) return false;
         }
      }
      return true;
   }
​
   private void flipColumn(int j, int[][] g) {
      IntStream.range(0,g.length).forEach(i -> {
         g[i][j] = 1 - g[i][j];
      });
   }
}
