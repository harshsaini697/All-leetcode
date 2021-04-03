class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxans = Math.max(maxans, i - st.peek());
                }
            }
        }
        return maxans; 
    }
}
