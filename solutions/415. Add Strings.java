class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 > len2 ? len1 : len2;
        
        int carry = 0;
        for(int i = 0; i < len; i++) {
            char n1 = i < len1 ? num1.charAt(len1 - i - 1) : '0';
            char n2 = i < len2 ? num2.charAt(len2 - i - 1) : '0';
            int number1 = n1 - '0';
            int number2 = n2 - '0';
            int num = (number1 + number2 + carry) % 10;
            carry = (number1 + number2 + carry) / 10;
            sb.append(num);
        }
        
        if(carry != 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
