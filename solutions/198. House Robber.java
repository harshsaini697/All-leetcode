class Solution {
    Integer[] memo;
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        memo = new Integer[nums.length];
        return recurse(nums, 0);
        
    }
    private int recurse(int[] nums, int index){
        //base
        if(index >= nums.length) return 0;
        //logic
        if(memo[index] != null) return memo[index];
        int case1 = nums[index] + recurse(nums, index + 2);
        int case2 = recurse(nums, index + 1);
        return memo[index] = Math.max(case1, case2);
    }
}
