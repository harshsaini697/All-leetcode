class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        
        int Larea = 0;
        int Garea = 0;
        
        Stack<Integer> st = new Stack();
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
                    Larea = heights[top] *(i - 1 - st.peek());
                }
            }
            Garea = Math.max(Larea, Garea);
        }
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                Larea = heights[top] * i;
            }else{
                Larea = heights[top] *(i - 1 - st.peek());
            }
            Garea = Math.max(Larea, Garea);
        }
        return Garea;
    }
}
