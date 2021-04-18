class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        //int min = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                }else if(j == n - 1){
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j + 1], matrix[i - 1][j - 1] ));
                }
                // if( i == n - 1){
                //     min = Math.min(matrix[i][j], min);
                // }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n ;i++){
            result = Math.min(result, matrix[n - 1][i]);
        }
        return result;
        //return min;
    }
}
