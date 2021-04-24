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
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length() - 1){
                if(op == '*'){
                    st.push(st.pop() * curr);
                }else if(op == '/'){
                    st.push(st.pop() / curr);
                }else if(op == '-'){
                    st.push(-1 * curr);
                }else{
                    st.push(curr);
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
