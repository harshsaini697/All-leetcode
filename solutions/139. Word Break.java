class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.isEmpty()) return true;
        boolean[] f = new boolean[s.length() + 1];
        HashSet<String> set = new HashSet<>(wordDict);
        f[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
