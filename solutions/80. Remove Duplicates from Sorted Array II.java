class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int j = 1;
        int count = 0;
        for(int i = 1; i < nums.length;i++){
            if(nums[i- 1] == nums[i]){
                count++;
            }else{
                count = 0;
            }
            if(count < 2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
