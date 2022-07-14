class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return new int[]{};
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        // using two pointer approach, we cna do with HashMap with O(n) space
        //Next approach was binary search since sorted but would take O(nLogN) and O(1) space.
        // this approach would take O(n) time and O(1) space.
        
        while(left < right) {
            if(numbers[left] + numbers[right] < target) {
                left++;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return result;
    }
}
