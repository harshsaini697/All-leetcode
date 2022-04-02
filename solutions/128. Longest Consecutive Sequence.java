class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        
        if(nums == null || nums.length == 0) return 0;
        
        for(int n : nums) set.add(n);
        
        int max = 0;
        for(int n : set) {
            int count = 1;
            if(!set.contains(n - 1)) {
                while(set.contains(n + count)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
