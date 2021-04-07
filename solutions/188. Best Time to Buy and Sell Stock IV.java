class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);
        
        for (int price : prices) {
            for (int j = k; j > 0 ; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }
​
        return T_ik0[k];
    }
}