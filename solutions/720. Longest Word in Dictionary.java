class Solution {
    TrieNode node;
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        node = new TrieNode();
        for(String word: words){
            insert(word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(node);
        TrieNode curr = null;
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i >= 0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
            }
        }
        return curr.word;
    }
    private void insert(String word){
        TrieNode root = node;
        char[] arr = word.toCharArray();
        for(char c: arr){
            if(root.children[c - 'a'] == null){
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c -'a'];
        }
        root.word = word;
    }
}
​
class TrieNode{
    String word;
    TrieNode[] children;
    TrieNode(){
        this.children = new TrieNode[26];
    }
}
