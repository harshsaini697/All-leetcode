/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
​
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0; // -1
        int high = 1; // 0
        
        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) < target){
            low = high;
            high *= 2;
        }
        
        if(reader.get(high) == target) return high;
        // 0  and 8
        while(low < high){
            int mid = low + (high - low)/2; //4
            int temp = reader.get(mid); // 5
            if(temp == target){
                return mid;
            }else if(target <= reader.get(mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return reader.get(low) == target ? low: -1;
    }
}
