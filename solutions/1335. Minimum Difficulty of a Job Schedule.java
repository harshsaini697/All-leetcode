class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty == null || jobDifficulty.length == 0){
            return -1;
        }
        int[][] dp = new int[d][jobDifficulty.length];
        dp[0][0] = jobDifficulty[0];
        for(int i = 1; i < jobDifficulty.length; i++){
            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i-1]);
        }
        for(int i = 1; i < d; i++){
            for(int j = i; j < jobDifficulty.length; j++ ){
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for(int schedule = j; schedule >= i; --schedule){
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][schedule - 1] + localMax);
                }
            }
        }
        return dp[d - 1][jobDifficulty.length - 1] == 0 ? -1 : dp[d - 1][jobDifficulty.length - 1];
    }
}
