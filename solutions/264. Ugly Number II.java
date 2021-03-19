class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        TreeSet<Long> q = new TreeSet<>();
        q.add(1l);
        for(int i = 0; i < n - 1; i++){
            long poll = q.pollFirst();
            q.add(poll * 2);
            q.add(poll * 3);
            q.add(poll * 5);
        }
        return q.first().intValue();
    }
}
