​
class Solution {
    public int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0) return new int[]{};
        int n = A.length;
        int[] res = new int[n];
        int p = 0;
        int q = n - 1;
        for(int i = n - 1; i >= 0; i--){
            if(Math.abs(A[p]) > Math.abs(A[q])){
                res[i] = A[p] * A[p];
                p++;
            }else{
                res[i] = A[q] * A[q];
                q--;
            }
        }
        return res;
    }
}
