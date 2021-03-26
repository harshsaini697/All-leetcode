class Solution {
    public int maxProfit(int[] prices) {
        int curr = 0;
        int buy = prices[0];
        int profit = 0;
        for(int i = 1 ;i < prices.length ;i++){
            int sell = prices[i] - buy;
            if(sell > profit){
                profit = sell;
            }
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return profit;
    }
}
​
// 7 1 5 3 6 4 
// 
​
