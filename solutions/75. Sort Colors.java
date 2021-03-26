class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int low = 0;
        int high = nums.length - 1;
        int i = 0;
        while(i <= high){
            if(nums[i] == 0){
                swap(nums, low++, i++);
            }else if(nums[i] == 2){
                swap(nums, high--, i);
            }else{
                i++;
            }
        } 
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
