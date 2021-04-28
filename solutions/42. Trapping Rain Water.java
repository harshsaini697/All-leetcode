class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
            
        }
        //System.out.println(Arrays.toString(left));
        right[height.length - 1] = height[height.length - 1];
        for(int j = height.length - 2; j >=0; j--){
            right[j] = Math.max(right[j+1], height[j]);
            
        }
        //System.out.println(Arrays.toString(right));
        for(int i = 0; i < height.length - 1; i++){
            ans += Math.min(right[i], left[i]) - height[i];
            //System.out.println(ans);
        }
        
        
        return ans;
    }
}
