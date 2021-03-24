class Solution {
    public int myAtoi(String s) {
        if(s == null ||s.length() == 0) return 0;
        int i = 0;
        int n = s.length();
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        
        int result = 0;
        
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}
