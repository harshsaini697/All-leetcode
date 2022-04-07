class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') { //edge cases
                st.push(i); 
            }
            else if (c == ')') {
                if(!st.isEmpty()) st.pop();
                else    sb.setCharAt(i, '#');
            }
        }
        // following this, we only have unbalanced paranthes marked as #
        
        //there is a possibility that ( occur
        while(!st.isEmpty()) {
            sb.setCharAt(st.pop(), '#');
        }
        
        return sb.toString().replaceAll("\\#", "");
    }
}
​
//lee(t(c)o)de)
// One intuitions is balance the parantheses using stack, store their idx
// mark their index in sb as #. 
// remove the # from input. 
​
​
​
