class Solution {
    public int largestRectangleArea(int[] heights) {
        int Larea = 0;
        int Garea = 0;
        
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < heights.length){
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i);
                i++;
            }else{
                int top = st.pop();
                if(st.isEmpty()){
                    Larea = heights[top] * i;
                }else{
                    Larea = heights[top] * (i - st.peek() - 1);
                }
            }
            Garea = Math.max(Garea, Larea);
        }
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                Larea = heights[top] * i;
            }else{
                Larea = heights[top] * (i - st.peek() - 1);
            }
            Garea = Math.max(Garea, Larea);
        }
        return Garea;
    }
}
