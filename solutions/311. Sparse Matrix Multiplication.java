class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = A[0].length;
        int p = B[0].length;
        int[][] result = new int[n][p];
        
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < m; k++) {
                if(A[i][k] == 0) {
                    continue;
                }
                for(int j = 0; j < p; j++) {
                    if(B[k][j] == 0) {
                        continue;
                    }
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
