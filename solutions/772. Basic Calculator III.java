class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack();
        int result = 0;
        int curr = 0;
        char op = '+';
        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                // get the number
                curr = (curr * 10) + (c - '0');
            }else if (c == '(') {
                 int j = i + 1; int braces = 1;
                 for (; j < s.length(); j++) {
                     if (s.charAt(j) == '(') ++braces;
                     if (s.charAt(j) == ')') --braces;
                     if (braces == 0) break;
                 }                
                 curr = calculate(s.substring(i + 1, j));
                 i = j;
             } 
            
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1){
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
                curr = 0;
                op = c;
            }
        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
