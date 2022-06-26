class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}};
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int count = 0;
                for(int[] dir: dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && y >= 0 && x < board.length && y < board[0].length && (board[x][y] == 1 || board[x][y] == 2)) {
                        count++;
                    }
                } 
                if(board[i][j] == 1 && count < 2) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && count > 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }  
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
