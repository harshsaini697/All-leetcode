class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || words == null || words.length == 0) return result;
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, result, i , j);
            }
        }
        return result;
        
    }
    private void dfs(char[][] board, TrieNode root, List<String> res, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        
        char c = board[i][j];
        if(c == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {   // found one
            res.add(root.word);
            root.word = null;     // de-duplicate
        }
        
        //drivving fn
        char temp = board[i][j];
            for(int[] d: dirs){
                board[i][j] = '#';
                dfs(board, root, res, i + d[0], j + d[1]);
                board[i][j] = temp;
            }
            
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            TrieNode p = root;
            for(char c: words[i].toCharArray()){
                int k = c - 'a';
                if(p.children[k] == null){
                    p.children[k] = new TrieNode();
                }
                p = p.children[k];
            }
            p.word = words[i];
        }
        return root;
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}
