class Solution {
    Map<Character, HashSet<Character>> map;
    int[] indegree;
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        map = new HashMap();
        StringBuilder result = new StringBuilder();
        indegree = new int[26];
        buildgraph(words);
        Queue<Character> q = new LinkedList<>();
        //add all 0 indegree nodes
        for(Character c : map.keySet()){
            if(indegree[c - 'a'] == 0){
                q.add(c);
            }
        }
        while(!q.isEmpty()){
            char curr = q.poll();
            result.append(curr);
            for(char c: map.get(curr)){
                indegree[c - 'a']--;
                if(indegree[c - 'a'] == 0){
                    q.offer(c);
                }
            }
        }
        if(result.length() != map.size()) return "";
        return result.toString();
    }
    private void buildgraph(String[] words){
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                map.putIfAbsent(words[i].charAt(j), new HashSet());
            }
        }
        for(int i = 0; i < words.length - 1; i++){
            String first =  words[i];
            String second = words[i + 1];
            int m = first.length();
            int n = second.length();
            if(m > n && first.startsWith(second)){
                map.clear();
            }
            for(int j = 0; j < m && j < n; j++){
                char out = first.charAt(j);
                char in = second.charAt(j);
                if(out != in){
                    if(!map.get(out).contains(in)){
                        map.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break;
                }
            }
        }
    }
}
