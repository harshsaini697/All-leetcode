class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int ans = Integer.MIN_VALUE;
        
        for (int i = 0; i <n; i++) {
            int cur = 1;
​
            for (int j = i; j < n; j++) {
                cur = cur * nums[j];
                ans = Math.max(ans, cur);
            }
        }
        
        return ans;
    }
}
