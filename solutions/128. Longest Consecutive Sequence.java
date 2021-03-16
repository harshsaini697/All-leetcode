class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums); // [0,1,1,2]
        int longestStreak = 1;
        int streak = 1;
        final int limit = nums.length;
        
        for(int i = 1; i < limit; i++){
            if(nums[i] != nums[i-1]){//skip duplicates
                if(nums[i] == nums[i - 1] + 1){
                    streak++;
                }else{
                    longestStreak = Math.max(longestStreak, streak);
                    streak = 1;
                }
            }
        }
        return Math.max(longestStreak, streak);
    }
}
//[1,2,3,4,100,200]
