class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int prev = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, heights[prev] * i);
                } else {
                    ans = Math.max(ans, heights[prev] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
