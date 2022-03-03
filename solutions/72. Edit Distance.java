class Solution {
    public int minDistance(String w1, String w2) {
        if(w1 == null || w2 == null) {
            return 0;
        }
        return helper(w1, w2, 0, 0);
        
    }
    
    private int helper(String w1, String w2, int i, int j) {
        // edge cases
        if(w1.length() == i) {
            return w2.length() - j;
        }
        if(w2.length() == j) {
            return w1.length() - i;
        }
        
        int ans = 0;
        if(w1.charAt(i) != w2.charAt(j)) {
            int insert = helper(w1, w2, i, j + 1);
            int delete = helper(w1, w2, i + 1, j);
            int replace = helper(w1, w2, i + 1, j + 1);
            ans = 1 + Math.min(insert, Math.min(delete, replace));
        } else {
            ans += helper(w1, w2, i + 1, j + 1);
        }
        return ans;
    }
}
