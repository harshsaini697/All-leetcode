class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        if(n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        int max = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && ( i - j < 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(max < i- j + 1){
                        start = j;
                        end = i;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
