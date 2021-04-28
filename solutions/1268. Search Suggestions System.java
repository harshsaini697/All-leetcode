        TrieNode curr = root;
        for(char c: s.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
        curr.word = s;
    }
    private void dfs(TrieNode curr, String prefix){
        if(result.size() == 3){
            return;
        }
        if(curr.isWord){
            result.add(curr.word);
        }
        
        for(char c = 'a'; c <= 'z'; c++){
            if(curr.children[c - 'a'] != null){
                dfs(curr.children[c - 'a'], prefix + c);
            }
        }
    }
    List<String> result;
    private List<String> prefixSearch(String prefix){
        TrieNode curr = root;
        result = new ArrayList<>();
        for(char c : prefix.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return result;
            }
            curr = curr.children[c - 'a'];
        }
        dfs(curr, prefix);
        return result;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if(products == null || products.length == 0) return res;
        for(int i = 0; i < products.length; i++){
            insert(products[i]);
        }
        String word = new String();
        for(char c: searchWord.toCharArray()){
            word += c;
            List<String> temp = prefixSearch(word);
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
