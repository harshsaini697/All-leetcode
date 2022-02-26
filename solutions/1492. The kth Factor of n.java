class Solution {
    public int kthFactor(int n, int k) {
        int d = 1;
        int count = 0;
        int factor = 0;
        while(d <= n) {
            if(n % d == 0) {
                count++;
                factor = d;
            } 
            d++;
            if(count == k) {
                return factor;
            }
        }
        return count == k ? factor : -1;
    }
}
​
