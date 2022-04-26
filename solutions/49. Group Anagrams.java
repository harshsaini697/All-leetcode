class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs == null) return list;
        
        HashMap<String, List<String>> map = new HashMap();
        
        for(int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            
            if(!map.containsKey(temp)) {
                map.put(temp, new ArrayList());
            }
            map.get(temp).add(strs[i]);
        }
        
        return new ArrayList(map.values());
    }
}
