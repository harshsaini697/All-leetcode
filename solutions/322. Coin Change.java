class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null|| coins.length == 0) return 0;
        return recurse(coins, amount, 0, 0);
    }
    private int recurse(int[] coins, int amount, int index, int coin){
        //base
        if(amount == 0){
            return coin;
        }
        if(index >= coins.length || amount < 0){
            return -1;
        }
        
        //logic
        //choose
        int case1 = recurse(coins, amount - coins[index], index, coin + 1);
        //notchosoe
        int case2 = recurse(coins, amount , index + 1, coin);
        if(case1== -1) return case2;
        if(case2== -1) return case1;
        
        return Math.min(case1, case2);
    }
}
