class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> res = new LinkedHashSet();
        if(nums == null || nums.length == 0) return new ArrayList<>(res);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(Math.abs(i - j) <= k && nums[j] == key) {
                    res.add(i);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
