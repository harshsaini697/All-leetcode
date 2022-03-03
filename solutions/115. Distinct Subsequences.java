class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        memo = new int[s.length() + 1][t.length() + 1];
        for(int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return helper(s, t, 0 ,0);
    }
    
    private int helper(String s, String t, int i, int j) {
        if(j == t.length()) {
            return 1;
        }
        if(i == s.length()) {
            return 0;
        }
        
        if(memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = 0;
        
        if(s.charAt(i) == t.charAt(j)) {
            ans = helper(s, t, i + 1, j + 1) + helper(s, t, i + 1, j);
        } else {
            // not choose
            ans = helper(s, t, i + 1, j);
        }
        return memo[i][j] = ans;
    }
}
