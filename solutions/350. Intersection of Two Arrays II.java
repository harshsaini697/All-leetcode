class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)return new int[]{};
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return intersect(nums2, nums1);
        }
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        for(int num: nums1){
            int bsIndex = binarySearch(nums2, index, n2 - 1, num);
            if(bsIndex != -1){
                li.add(num);
                index = bsIndex + 1;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
        
    }
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low )/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid - 1] ){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid]  > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
