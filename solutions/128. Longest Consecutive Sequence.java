class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int longestStreak = 0;
        
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            int streak = 1;
            while(arrayhas(nums, curr + 1)){
                curr += 1;
                streak++;
            }
            longestStreak = Math.max(longestStreak, streak);
        }
        return longestStreak;
    }
    
    private boolean arrayhas(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}
