class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0) return false;
                //      n      e       w       s
        int[][] dirs = {{0,1}, {1,0}, {-1,0} ,{0,-1}};
        int x = 0;
        int y = 0;
        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                x += dirs[0][0];
                y += dirs[0][1];
            }else if( c == 'D'){
                x += dirs[3][0];
                y += dirs[3][1];
            }else if( c == 'R'){
                x += dirs[1][0];
                y += dirs[1][1];
            }else{
                x += dirs[2][0];
                y += dirs[2][1];
            }
        }
        return x == 0 && y == 0;
    }
}
