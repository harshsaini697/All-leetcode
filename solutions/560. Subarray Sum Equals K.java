class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;
        int rsum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            rsum += nums[i];
            if(map.containsKey(rsum - k)) {
                res += map.get(rsum - k);
            }
            map.put(rsum, map.getOrDefault(rsum, 0) + 1);
        }
        return res;
    }
}
