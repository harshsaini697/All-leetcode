class MovingAverage {
    int[] arr;
    int last;
    double average = 0;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        arr = new int[size];
        last = 0;
        this.size = size;
    }
    
    public double next(int val) {
        double sum = average * Math.min(size, last);
        //System.out.println(sum);
        double new_sum = sum - arr[last % size];
        //System.out.println(new_sum);
        arr[last++ % size] = val;
        if(last < size){
            average = (val + new_sum)/ last;
        }else{
            average = (val + new_sum) / size;
        }
        return average;
    }
}
​
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
