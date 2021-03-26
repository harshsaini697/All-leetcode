class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 1;
        int count = nums.length;
        int j = 1;
        while(i < nums.length){
            if(nums[i - 1] != nums[i]){
                nums[j] = nums[i];
                j++;
            }else{
                count--;
            }
            i++;
        }
        return count;
    }
}
