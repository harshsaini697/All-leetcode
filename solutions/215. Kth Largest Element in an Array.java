class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] bucket = new int[max - min + 1];
        
        for (int num : nums) {
            bucket[num - min]++;
        }
        
        int i = max - min;
        while (k > 0) {
            while(bucket[i] == 0 && i > 0) i--;
            if(bucket[i] == 0) return -1; 
            if(bucket[i] >= k) return i + min;
            else {
                k -= bucket[i];
                i--;
            }
        }
           
        return -1;
    }
}
