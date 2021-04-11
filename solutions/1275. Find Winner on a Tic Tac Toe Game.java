class Solution {
    public String tictactoe(int[][] moves) {
        if(moves == null || moves.length == 0 ) return "Draw";
        int[] rows = new int[3];
        int[] cols = new int[3];
        // int A = 0;
        // int B = 0;
        boolean A = true;
        int diagonal = 0;
        int antidiagonal = 0;
        for(int i = 0; i < moves.length; i++){
            int player = A ?  1 : -1;
            int row = moves[i][0];
            int col = moves[i][1];
            //Rows count
            rows[row] += player;
            // cols count
            cols[col] += player;
            // diagonal count
            if(row == col){
                diagonal += player;
            }
            // antidiagonal count
            if(row + col == rows.length - 1){
                antidiagonal += player;
            }
            A = !A;
        }
        // System.out.println(Arrays.toString(rows));
        // System.out.println(Arrays.toString(cols));
        for(int i = 0; i < rows.length; i++){
            if(rows[i] == 3 || cols[i] == 3){
                return "A";
            }else if(rows[i] == -3 || cols[i] == -3){
                return "B";
            }
        }
        if(diagonal == 3 || antidiagonal == 3){
            return "A";
        }else if(diagonal == -3 || antidiagonal == -3){
            return "B";
        }
        if(moves.length < 9){
            return "Pending";
        }
        return "Draw";
    }
}
