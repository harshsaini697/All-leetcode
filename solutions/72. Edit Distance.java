class Solution {
    public int minDistance(String word1, String word2) {
        int n = word2.length();
        int m = word1.length();
        int[][] dp = new int[n + 1][m + 1];
        if(m == 0) return n;
        if(n == 0) return m;
        //Most important step to govern the rule of Bottom Up approach. 
        for(int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word2.charAt(i - 1) ==  word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 +  Math.min(dp[i - 1][j], Math.min(dp[i - 1][ j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
