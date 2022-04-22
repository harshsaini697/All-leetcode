class Solution {
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        HashSet<String> set = new HashSet();
        for(String str: wordDict) {
            set.add(str);
        }
        if(s == null) return result;
        List<String> temp = new ArrayList<>();
        
        dfs(s, set, temp, 0);
        return result;
        
    }
    
    private void dfs(String s, Set<String> set, List<String> temp, int index) {
        if(index == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String t: temp) {
                sb.append(t);
                sb.append(" ");
            }
            result.add(new String(sb.toString().trim()));
        }
        
        for(int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if(set.contains(str)) {
                temp.add(str);
                dfs(s, set, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
