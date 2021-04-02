class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int curSum = numbers[lo] + numbers[hi];
            if (curSum == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (curSum > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1, -1};
    }
}
