class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);
        map.put('L', 50);map.put('C', 100);map.put('A', 0);
        map.put('M', 1000);map.put('D', 500);
        
        if(s == null || s.length() == 0) return 0;
        int result = 0;
        char prev = 'A';
        for(char c: s.toCharArray()){
            int count = 0;
            if(prev == 'I' && (c =='V' || c == 'X')){
                count = map.get(c) - 2 * map.get(prev);
            }else if(prev == 'X' && (c =='L' || c == 'C')){
                count = map.get(c) - 2 * map.get(prev);
            }
            else if(prev == 'C' && (c =='D' || c == 'M')){
                count = map.get(c) - 2 * map.get(prev);
            }else{
                count = map.get(c);
            }
            result += count;
            prev = c;
        }
        return result;
    }
}
