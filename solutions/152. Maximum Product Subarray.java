class Solution {
    public int maxProduct(int[] A) {
        if(A == null) return 0;
        
        int left = 0;
        int right = 0;
        int res = A[0];
        int n = A.length;
        for(int i = 0; i < n; i++){
            left = (left == 0 ? 1 : left ) * A[i];
            right = (right == 0 ? 1: right ) * A[n - i - 1];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
}
