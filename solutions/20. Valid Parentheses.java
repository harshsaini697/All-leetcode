class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        int i = 0;
        while(i < s.length()){
            char temp = s.charAt(i);
            if(!map.containsKey(temp)){
                st.push(temp);
            }else{
                if(!st.isEmpty() && st.peek() == map.get(temp)){
                    st.pop();
                }else{
                    return false;
                }
            }
            i++;
        }
        return st.size() == 0;
    }
}
