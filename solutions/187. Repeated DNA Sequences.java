class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        // Empty Result - returning Empty List
        if(s == null || s.length() == 0 ) return new ArrayList<>(result);
        Set<String> set = new HashSet<>();
        int i = 0;
        int L = 10;
        int n = s.length();
        while(i < n - L + 1){
            String temp = s.substring(i, i + L);
            if(!set.contains(temp)){
                set.add(temp);
            }else{
                result.add(temp);
            }
            i++;
        }
        return new ArrayList<>(result);
    }
}
