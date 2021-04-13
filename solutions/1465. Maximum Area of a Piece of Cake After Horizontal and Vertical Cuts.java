class Solution {
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);Arrays.sort(verticalCuts);
        int maxh = Math.max(h - horizontalCuts[horizontalCuts.length - 1], horizontalCuts[0]);
        for(int i = 1; i < horizontalCuts.length; i++){
            maxh = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], maxh);
        }
        int maxv = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 1; i < verticalCuts.length; i++){
            maxv = Math.max(verticalCuts[i] - verticalCuts[i - 1], maxv);
        }
        long ans = 1L * maxh * maxv;
        
        return  (int) (ans % 1000000007);
    }
}
