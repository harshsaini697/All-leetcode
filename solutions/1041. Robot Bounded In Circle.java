class Solution {
    public boolean isRobotBounded(String instructions) {
        if(instructions == null || instructions.length() == 0)    return false;
        //              n       w       s       e
        int[][] dirs = {{0,1}, {-1,0},{0,-1},{1,0}};
        int i = 0;
        int x = 0, y = 0;
        for(char c : instructions.toCharArray()){
            switch(c){
                case 'G':
                    x = x + dirs[i][0];
                    y = y + dirs[i][1];
                    break;
                case 'L' :
                    i = (i + 1) % 4;
                    break;
                case 'R':
                    i = (i + 3) % 4;
                    break;
            }
        }
        return (i != 0) || (x == 0 && y == 0);
    }
}
