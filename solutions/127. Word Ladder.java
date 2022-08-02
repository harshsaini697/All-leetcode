class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.isEmpty()) return 0;
        
        HashSet<String> words = new HashSet(wordList);
        if(!words.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        
        int count = 1;
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                char[] temp = q.poll().toCharArray();
                for(int j = 0; j < temp.length; j++) {
                    char hold = temp[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        temp[j] = c;
                        String curr = String.valueOf(temp); 
                        if(words.contains(curr)) {
                            if(endWord.equals(curr)) {
                                return count + 1;
                            }
                            words.remove(curr);
                            q.offer(curr);
                        }
                    }
                    temp[j] = hold;
                }
            }
            count++;
        }
        return 0;
    }
}
