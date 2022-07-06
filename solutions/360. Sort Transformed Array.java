class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return new int[]{};
        int len = nums.length;
        int[] result = new int[len];
        
        for(int i = 0; i < len; i++) {
            result[i] = getQuadRes(nums[i], a, b, c);
        }
        
        Arrays.sort(result);
        return result;
    }
    
    private int getQuadRes(int num, int a, int b, int c) {
        return (num * num) * a + num * b + c;
    }
}
