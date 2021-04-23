class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }
    private int helper(String word1, String word2, int i, int j){
        
        if(j == word2.length())
            return word1.length() - i;
        if(i == word1.length())
            return word2.length() - j;
        int ans;
        
        if(word1.charAt(i) != word2.charAt(j)){
            int insert = helper(word1, word2, i, j+1);
            int delete = helper(word1, word2, i+1, j);
            int replace = helper(word1, word2, i+1, j+1);
            
            ans = 1 + Math.min(insert, Math.min(delete, replace));
        }
        else
            ans = helper(word1, word2, i+1, j+1);
        return ans;
    }
}
