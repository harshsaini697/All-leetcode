class Solution {
    public int minCost(String s, int[] cost) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            int a = s.charAt(i); // a
            int b = s.charAt(i - 1);//a
            if(a == b){
                res += Math.min(cost[i], cost[i - 1]);
                cost[i] = Math.max(cost[i], cost[i - 1]);
            }
        }
        return res;
    }
}
