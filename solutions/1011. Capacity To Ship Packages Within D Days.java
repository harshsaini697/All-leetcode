class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0) return 0;
        int min = 0;
        int max = 0;
        for(int i = 0; i < weights.length; i++){
            min = Math.max(min, weights[i]); //min capacity that we need
            max += weights[i];
        }
        while(min <= max){
            int mid = min + (max - min) / 2;
            int currMax = 0;
            int count = 1;
            for(int i = 0; i < weights.length; i++){
                if(currMax + weights[i] > mid){
                    count++;
                    currMax = 0;
                }
                currMax += weights[i];
            }
            if(count > D){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return min;
    }
}
