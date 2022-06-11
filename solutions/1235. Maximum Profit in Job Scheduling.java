class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if(startTime == null || startTime.length == 0) return 0;
        int n = startTime.length;
        
        int[] memo = new int[50001];
        Arrays.fill(memo, -1);
        int[][] jobs = new int[n][3];
        for(int i = 0; i < jobs.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        //Get StartTime after sorting again as values might not be in order
        for (int i = 0; i < startTime.length; i++) {
            startTime[i] = jobs[i][0];
        }
        
        return findMaxProfit(jobs, startTime, n, 0, memo);
    }
    
    private int findMaxProfit(int[][] jobs, int[] startTime, int n, int position, int[] memo) {
        if(position == n) {
            return 0;
        }
        
        if(memo[position] != -1) {
            return memo[position];
        }
        //get the next job to start
        int nextIndex = findNextJob(startTime, jobs[position][1]);
        
        //get profit
        int maxProfit = Math.max(findMaxProfit(jobs, startTime, n, position + 1, memo), jobs[position][2] + findMaxProfit(jobs, startTime, n, nextIndex, memo));
        
