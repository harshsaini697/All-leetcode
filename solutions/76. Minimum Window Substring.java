class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = map.size();
        
        int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    match--;
                }
            }
            
            while(match == 0){
                char temp = s.charAt(begin);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0){
                        match++;
                    }
                }
                if(end - begin < len){
                    len = end - begin + 1;
                    head = begin;
                }
                begin++;
            }
            end ++;
        }
        return len == Integer.MAX_VALUE ? "": s.substring(head, head + len);
    }
}
