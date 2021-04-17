class Solution {
    public String minWindow(String S, String T) {
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
​
        while (right < S.length()) {
            int tIndex = 0;
            // use fast pointer to find the last character of T in S
            while (right < S.length()) {
                if (S.charAt(right) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == T.length()) {
                    break;
                }
                right++;
            }
            // if right pointer is over than boundary
            if (right == S.length()) {
                break;
            }
​
// use another slow pointer to traverse from right to left until find first character of T in S
            int left = right;
            tIndex = T.length() - 1;
            while (left >= 0) {
                if (S.charAt(left) == T.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0) {
                    break;
                }
                left--;
            }
            // if we found another subsequence with smaller length, update result
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                result = S.substring(left, right + 1);
            }
// WARNING: we have to move right pointer to the next position of left pointer,NOT the next position
            // of right pointer
            right = left + 1;
        }
        return result;
​
    }
}
