class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2);
    }
    
    private int helper(String t1, String t2) {
        if(t1.length() == 0 || t2.length() == 0) {
            return 0;
        }
        int val = 0;
        if(t1.charAt(0) == t2.charAt(0)) {
            val = 1 + helper(t1.substring(1), t2.substring(1));
        } else {
            val = Math.max(helper(t1, t2.substring(1)), helper(t1.substring(1), t2));
        }
        return val;
    }
}
