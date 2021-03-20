class Solution {
    int ans = 0;
    Map<Integer, Integer> map;
    public int pathSum(int[] nums) {
        map = new HashMap<>();
        for(int num: nums){
            map.put(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0);
        return ans;
    }
    private void dfs(int node, int sum){
        if(!map.containsKey(node)){
            return;
        }
        sum += map.get(node);
        int depth = node /10; 
        int pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;
        if(!map.containsKey(left) && !map.containsKey(right)){
            ans += sum;
        }else{
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}
