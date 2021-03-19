class Solution {
    public int nthUglyNumber(int n) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int n2 = dp[p1] * 2;// 2
            int n3 = dp[p2] * 3;//3
            int n5 = dp[p3] * 5;//5
            int min = Math.min(n2, Math.min(n3, n5));//2
            if(n2 == min){
                dp[i] = n2;
                p1++;
            }
            if(n3 == min){
                dp[i] = n3;
                p2++;
            }
            if(n5 == min){
                dp[i] = n5;
                p3++;
            }
        }
        return dp[n - 1];
    }
}
