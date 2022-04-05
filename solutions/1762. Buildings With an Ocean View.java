class Solution {
    public int[] findBuildings(int[] heights) {
        // strictly decreasing elements
        //
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] <= heights[i]){
                st.pop();
            }
            st.push(i);
        }
        //1,3,2,4
        int[] buildings = new int[st.size()];
        for(int i = buildings.length - 1 ; i >= 0 ; i--) {
            buildings[i] = st.pop();
        }
        return buildings;
    }
}
