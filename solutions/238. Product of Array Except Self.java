class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        for(int i = 1; i < nums.length; i++){
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >=0 ; i--){
            R[i] = nums[i + 1] * R[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
