class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int res = 0; 
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num * 10 + (int) (c - '0');
            } else if(c == '+' || c == '-') {
                res += num * sign;
                num = 0;
                sign = (c == '+' ? 1: -1);
            } else if(c == '(') {
                stack.add(res);
                stack.add(sign);
                res = 0;
                sign = 1;
            } else if(c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        return res + sign * num;
    }
}
