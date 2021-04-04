class StreamChecker {
    TrieNode root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();  
        createTrie(words);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for(int i = sb.length() - 1; i >= 0 ; i--){
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if(node != null && node.word){
                return true;
            }
            if(node == null) return false;
            
        }
        return false;
    }
    
    private void createTrie(String[] words){
        for(String s: words){
            TrieNode node = root;
            int len = s.length();
            for(int i = len - 1; i >=0; i--){
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.word = true;
        }
    }
}
​
class TrieNode {
    boolean word;
    TrieNode[] next = new TrieNode[26];
}
/**
 * Your StreamChecker object will be instantiated and called as such:
