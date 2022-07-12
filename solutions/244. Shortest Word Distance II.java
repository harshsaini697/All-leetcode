class WordDistance {
    Map<String, ArrayList<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            if(!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indexes1 = map.get(word1);
        List<Integer> indexes2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < indexes1.size(); i++) {
            for(int j = 0; j < indexes2.size(); j++) {
                min = Math.min(Math.abs(indexes1.get(i) - indexes2.get(j)), min);
            }
        }
        return min;
    }
}
​
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
