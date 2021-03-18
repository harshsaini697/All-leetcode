class Solution {
    int max = 1;
    int start = 0 ;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        if(n < 2) return s;
        
        for(int i = 0; i < n; i++){
            expandAroundCenter(s, i, i);
            if(i < n - 1 &&s.charAt(i) == s.charAt(i+1)) 
                expandAroundCenter(s, i, i + 1); // even case
            
        }
        return s.substring(start, start + max);
    }
    
    private void expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        if(R - L - 1 > max){
            max = R - L - 1;
            start = L + 1;
        }
    }
    
}
