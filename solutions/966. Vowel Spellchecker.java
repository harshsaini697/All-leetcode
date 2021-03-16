class Solution {
    Set<String> words;
    HashMap<String, String> word_lc;
    HashMap<String, String> word_vow;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        words = new HashSet<>();
        word_lc = new HashMap<>();
        word_vow = new HashMap<>();
        
        for(String word: wordlist){
            words.add(word);
            
            //lowercase
            String wordlow = word.toLowerCase();
            word_lc.putIfAbsent(wordlow, word);
            
            String wordlowDV = devowel(wordlow);
            word_vow.putIfAbsent(wordlowDV, word);
        }
        String[] ans = new String[queries.length];
        int t = 0;
        for(String query: queries){
            ans[t++] = solve(query);
        }
        return ans;
    }
    private String solve(String query){
        //perfect match
        if(words.contains(query)){
            return query;
        }
        String queryL = query.toLowerCase();
        if(word_lc.containsKey(queryL)){
            return word_lc.get(queryL);
        }
        String queryLV = devowel(queryL);
        if(word_vow.containsKey(queryLV)){
            return word_vow.get(queryLV);
        }
        return "";
    }
    
    private String devowel(String s){
        StringBuilder ans = new StringBuilder();
        for(char c: s.toCharArray()){
            ans.append(isVowel(c) ? '*' : c);
        }
        return ans.toString();
    }
    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
