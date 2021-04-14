class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }   
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int begin = 0, end = 0, counter = 0, res = 0;
        
        while(end < s.length()){
            char in = s.charAt(end++);
            map.put(in, map.getOrDefault(in, 0) + 1);
            if(map.get(in) == 1) counter++; //distinct
            
            while(counter > 2){
                char out = s.charAt(begin++);
                map.put(out, map.get(out) - 1);
                if(map.get(out) == 0) counter--;//removed the distinct element
            }
            res = Math.max(end - begin, res);
        }
        return res;
    }
}
