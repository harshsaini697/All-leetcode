class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S.length() == 0 || S.length() < K) return 0;
        int begin = 0, end = 0, counter = 0, res = 0;
        Set<Character> set = new HashSet<>();
        while(end < S.length()){
            char c = S.charAt(end);
            if(set.add(c)){
                end++;
            }else{
                set.remove(S.charAt(begin++));
            }
            if(end - begin == K){
                res++;
                set.remove(S.charAt(begin++));
            }
        }
        return res;
        
    }
}
