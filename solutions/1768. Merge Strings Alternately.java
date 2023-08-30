class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2;
        }
        if (word2 == null || word2.length() == 0) {
            return word1;
        }
        int n = word1.length();
        int m = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < n && j < m) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
​
        if (i > 0) {
            sb.append(word2.substring(j, word2.length()));
        }
        if (j > 0) {
            sb.append(word1.substring(i, word1.length()));
        }
        return sb.toString();
    }
}
​
