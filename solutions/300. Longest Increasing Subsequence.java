class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        memo = new int[nums.length + 1][nums.length];
        for(int[] m: memo) {
            Arrays.fill(m, -1);
        }
        return lengthOfLIS(nums, 0, -1);
    }
    
    private int lengthOfLIS(int[] nums, int currPos, int prevPos) {
        if(currPos == nums.length) return 0;
        
        if(memo[prevPos + 1][currPos] >= 0) return memo[prevPos + 1][currPos];
        //take
        int take = 0;
        if(prevPos < 0 || nums[prevPos] < nums[currPos]) {
            take = 1 + lengthOfLIS(nums, currPos + 1, currPos);
        }
        int notTake = lengthOfLIS(nums, currPos + 1, prevPos);
        return memo[prevPos + 1][currPos] = Math.max(take, notTake);
        //not take
    }
}
