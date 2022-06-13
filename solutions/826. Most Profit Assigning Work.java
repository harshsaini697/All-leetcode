class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Pair<Integer, Integer>[] jobs = new Pair[N];
        
        for(int i = 0; i < N; i++) {
            jobs[i] = new Pair(difficulty[i], profit[i]);
        }
        
        // Sort the inputs
        Arrays.sort(worker);
        Arrays.sort(jobs, (a,b) -> a.getKey() - b.getKey());
        int ans = 0;
        int i = 0;
        int best = 0;
        for(int skill: worker) {
            //iterate through all matching jobs and find the profit giving job
            while(i < N && skill >= jobs[i].getKey()) {
                best = Math.max(best, jobs[i].getValue());
                i++;
            }
            ans += best;
        }
        return ans;
    }
}
