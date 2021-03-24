class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < 4) return false;
        int sum = 0;
        // Find the Side
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 4 != 0) return false;
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, new int[4], sum / 4, 0);
    }
    private boolean dfs(int[] nums, int[] square, int target, int index){
        // Base
        if(index == nums.length){
            if(square[0] == target && square[1] == target && square[2] == target && square[3] == target){
                return true;
            }
            return false;
        }
        
        // Logic
        
        for(int i = 0; i < square.length; i++){
            if(square[i] + nums[index] <= target){
                square[i] += nums[index];
                if(dfs(nums, square, target, index + 1)) return true;
                square[i] -= nums[index];
            }
        }
        return false;
    }
    //
    private void reverse(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
