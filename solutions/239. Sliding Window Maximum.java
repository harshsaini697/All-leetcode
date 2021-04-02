class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(!dq.isEmpty() && dq.peek() < i - k + 1){
                dq.poll();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[dq.peek()];                
            }
        }
        return res;
    }
}
