class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        //int range = nums.length + 1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > n  || nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for(int num: nums){
            num = Math.abs(num);
            if(num > n) continue;
            num--;
            if(nums[num] > 0){
                nums[num] *= -1;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0)
                return i + 1;
        }
        return n + 1;
    }
}
