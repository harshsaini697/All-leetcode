class Solution {
    public int arraySign(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int countneg = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                countneg++;
            }else if (nums[i] == 0){
                return 0;
            }
        }
        return countneg % 2 == 0 ? 1: -1;
    }
}
