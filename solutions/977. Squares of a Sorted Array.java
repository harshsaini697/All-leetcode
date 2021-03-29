class Solution {
    public int[] sortedSquares(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(nums == null || nums.length == 0) return new int[]{};
        
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i] *nums[i]);
        }
        int i = 0;
        while(!pq.isEmpty()){
            nums[i++] = pq.poll();
        }
        return nums;
    }
    
}
