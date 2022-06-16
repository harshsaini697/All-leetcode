class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        
        Stack<Integer> st = new Stack<>();
        int x, y;
        for(int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            if(temp.equals("+")) {
                st.add(st.pop() + st.pop());
            } else if(temp.equals("-")) {
                x = st.pop();
                y = st.pop();
                st.add(y - x);
            } else if(temp.equals("*")) {
                st.add(st.pop() * st.pop());
            } else if(temp.equals("/")) {
                x = st.pop();
                y = st.pop();
                st.add(y / x);
            } else {
                st.add(Integer.parseInt(temp));
            }
        }
        return st.pop();
    }
}
