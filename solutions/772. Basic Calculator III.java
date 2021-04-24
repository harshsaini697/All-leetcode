class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack();
        int result = 0;
        int curr = 0;
        char op = '+';
        int n = s.length();
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr =  curr * 10 + (int)(c - '0');
            }else if(c == '('){
                int braces = 1;
                int j = i + 1;
                for(; j< n; j++){
                    if(s.charAt(j) == '(') braces++;
                    if(s.charAt(j) == ')') braces--;
                    if(braces == 0) break;
                }
                curr = calculate(s.substring(i + 1, j));
                i = j;
            }
            
            if(c == '*' || c == '+' || c == '-' ||c == '/' || i == n - 1){
                switch(op){
                    case '+':
                        st.push(curr);
                        break;
                    case '-':
                        st.push(-curr);
                        break;
                    case '*':
                        st.push(st.pop() * curr);
                        break;
                    case '/':
                        st.push(st.pop() / curr);
                        break;
                }
                op = c;
                curr = 0;
            }
        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
