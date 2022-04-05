class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length < 2) return intervals;
        
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(interval[1], list.getLast()[1]);
            }
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}
