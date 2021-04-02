class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        if(words == null || words.length == 0) return list;
        HashSet<String> set = new HashSet<>();
        //sort the array so that we only send the words that are smaller than the current word
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        //for(int i = 0; i < words.length; i++) set.add(words[i]);
        for(int i = 0; i < words.length; i++){
            if(canForm(words[i], set)) list.add(words[i]);
            set.add(words[i]);
        }
        return list;
    }
    
    private boolean canForm(String word, Set<String> set){
        if (set.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        for(int i = 1; i < word.length() + 1; i++){    
            dp[0] = true;
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(word.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
