class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        if(m == 0) return n;
        if(n == 0) return m;
        for(int i = 0; i <= m; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) ==  word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1+  Math.min(dp[i - 1][j], Math.min(dp[i - 1][ j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
        // return helper(word1, word2, 0, 0);
    }
    private int helper(String word1, String word2, int i , int j){
        
        if(j == word2.length()) return word1.length() - i;
        if(i == word1.length()) return word2.length() - j; // no of letters left
        int ans;
        ///
        if(word1.charAt(i) != word2.charAt(j)){
            int insert = helper(word1, word2, i, j + 1);
            int delete = helper(word1, word2, i + 1, j );
            int replace = helper(word1, word2, i + 1, j + 1);
            ans = 1 + Math.min(insert, Math.min(delete, replace));
        }else{
            ans = helper(word1, word2, i + 1, j + 1);
        }
        return ans;
    }
}
