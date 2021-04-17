class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            len = Math.max(len, nums[i]);
        }
        
        int[] freq = new int[len + 1];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]] += nums[i];
        }
        int skip = 0; int take = freq[0];
        for(int i = 1; i < freq.length; i++){
            int temp = skip;
            skip = Math.max(take, skip);
            take = temp + freq[i];
        }
        return Math.max(skip, take);
    }
}
