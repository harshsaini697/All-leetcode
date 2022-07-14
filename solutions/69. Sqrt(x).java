class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2;
        int right = x/2;
        int mid = left;
        while(left <= right) {
            mid = left + (right - left)/2;
            long mul = (long) mid * mid;
            if(mul == x) {
                return mid;
            } else if(mul < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
