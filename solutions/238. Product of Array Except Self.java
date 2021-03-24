class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        // int[] R = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = nums[i - 1] * result[i - 1];
        }
        int R = 1;
        for(int i = nums.length - 1; i >=0 ; i--){
            result[i] = result[i] * R;
            R *= nums[i];
        }
        // for(int i = 0; i < nums.length; i++){
        //     result[i] = L[i] * R[i];
        // }
        return result;
    }
}
