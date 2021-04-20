class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxsum = nums[0];
        int rsum = nums[0];
        //Kadane's Algo
        for(int i = 1; i < nums.length; i++){
            rsum = Math.max(rsum + nums[i], nums[i]);
            maxsum = Math.max(rsum, maxsum);
        }
        return maxsum;
    }
}
