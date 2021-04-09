class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int temp = board[i][j];
                int count = 0;
                for(int[] d : dirs){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x >= 0 && y >= 0 && x < n && y < m && (board[x][y] == 2 || board[x][y] == 1 )){
                        count++;
                    }
                }
                if(board[i][j] == 1 && ( count < 2 || count > 3)){
                    board[i][j] = 2;
                } 
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] %= 2;        
            }
        }
        
    }
}
