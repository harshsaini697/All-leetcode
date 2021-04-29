class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){ return findMedianSortedArrays(nums2, nums1);}
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        
        while(low <= high){
            int partX = (low + high) /2 ; // integer overflow
            int partY = (x + y + 1)/2 - partX;
            
            int xl = partX == 0 ? Integer.MIN_VALUE: nums1[partX - 1]; // 0 since -1 out of bounds
            int xr = partX == x ? Integer.MAX_VALUE: nums1[partX];
            int yl = partY == 0 ? Integer.MIN_VALUE: nums2[partY - 1];
            int yr = partY == y ? Integer.MAX_VALUE: nums2[partY];
            if(xl <= yr && yl <= xr){
                if((x + y )% 2 == 0){
                    return (double)(Math.max(xl,yl) + Math.min(xr, yr))/ 2;
                }else{
                    return Math.max(xl, yl);
                }
            }else if(xl > yr){
                high = partX - 1;
            }else{
                low = partX + 1;
            }
        }
        return 0;
    }
}
​
​
