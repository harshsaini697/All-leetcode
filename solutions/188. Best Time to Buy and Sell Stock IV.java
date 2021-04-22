class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null) return 0;
        if(2*k > prices.length){
            int res = 0;
            for(int i = 1; i < prices.length; i++){
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }
        int result = 0;
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k + 1];
        
        for(int price: prices){
            for(int i = 1; i <= k; i++){
                buy[i] = Math.min(buy[i], price - sell[i - 1]);
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k];
    }
}
