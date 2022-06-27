class Solution {
    int minLen;
    public int numSquares(int n) {
        minLen = n;
        if (Math.sqrt(n) == (int) Math.sqrt(n)) return 1;
        backtrack(n, n, 0);
        return minLen;
    }
    private void backtrack(int n, int curr, int len) {
        if(curr == 0) {
            minLen = Math.min(minLen, len);
            return;
        } else if(curr > 0) {
            int num = (int) Math.sqrt(curr);
            for(int i = num; i >= 1; i--) {
                backtrack(n, curr - i * i, len + 1);
            }
        }
        
    }
}
