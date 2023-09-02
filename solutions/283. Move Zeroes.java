class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        if (nums.length == 1) return;
        int x = 0, y = 0;
        
        while (y < nums.length) {
            if (nums[y] != 0) {
                swap(nums, x++, y);
            }
            y++;
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = 0;
        nums[x] = temp;
    }
}
​
//[0,1,0,3,12]
//[1,3,0,012]
