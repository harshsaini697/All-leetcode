/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;
​
    public Interval() {}
​
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
​
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        if(schedule == null || schedule.size() == 0){
            return result;
        }
        List<Interval> timeLine = new ArrayList<>();
        schedule.forEach(e -> timeLine.addAll(e));
        //sort based on start
        Collections.sort(timeLine, (a,b) -> a.start - b.start);
        Interval curr = timeLine.get(0);
        for(int i = 0; i < timeLine.size(); i++){
            Interval next = timeLine.get(i);
            if(curr.end < next.start){
                result.add(new Interval(curr.end, next.start));
                curr = next;
            }else{
                curr = curr.end < next.end ? next : curr;
            }
        }
        return result;
    }
}
