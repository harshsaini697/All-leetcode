class Solution {
    Set<Integer> set;
    public boolean isHappy(int n) {
        set = new HashSet<>();
        while(set.add(n)){
            int sqsum = 0;
            while(n > 0){
                int remain = n % 10; // taking out integers
                sqsum += remain * remain;
                n /= 10;
            }
            if(sqsum == 1){
                return true;
            }else{
                n = sqsum;
            }
        }
        return false;
    }  
}
​
