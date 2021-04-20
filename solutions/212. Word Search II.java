class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if(board == null || words == null || board.length == 0) return result;
        
        for(String word: words){
            if(exists(board, word)){
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean exists(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0, i , j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int index, int i, int j){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        //driving
        if(board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            for(int[] d: dirs){
                board[i][j] = '#';
                boolean r = dfs(board, word, index + 1, i + d[0], j + d[1]);
                board[i][j] = temp;
                if(r) return true;
            }
        }
        return false;
    }
}
