class Solution {
    public int minSteps(String s, String t) {
        if(s.length() != t.length()) return 0;
        
        int[] freqS = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            freqS[t.charAt(i) - 'a']--; 
        }
        int steps = 0;
        for (int step : freqS) {
            if (step > 0) {
                steps += step;
            }
        }
        return steps;
    }
}
