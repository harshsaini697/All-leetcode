class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        int i = 0;//e
        int j = s.length() - 1;//r
        
        while(i < j) { 
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
