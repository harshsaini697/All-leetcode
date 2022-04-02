class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        boolean cons = false;
        int longestStreak = 1;
        int streak = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                if(nums[i] == nums[i - 1] + 1) {
                    streak++;
                    longestStreak = Math.max(longestStreak, streak);
                } else {
                    streak = 1;
                }
            }
        }
        return longestStreak;
    }
}
