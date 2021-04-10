class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int cur = 0;
        int low = 0;
        int high = height.length - 1;
        
        while(low < high){
            //cur = 0;
            if(height[low] <= height[high]){
                cur = height[low] * (high - low);
                low++;
            }else{
                cur = height[high] * (high - low);
                high--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
