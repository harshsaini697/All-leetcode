class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0){
            return 0;
        }
        int n = weights.length;
        int max = 0;
        int min = 0;
        for(int i = 0; i < n; i++){
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        
        while(min <= max){
            int count = 1;
            int mid = min + (max - min) / 2;
            int currMax = 0;
            for(int i = 0; i < n; i++){                
                if(currMax + weights[i] > mid){
                    count++;
                    currMax = 0;
                }
                currMax += weights[i];
            }
            if(count <= D){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
}
