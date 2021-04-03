class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0) return 0;
        Set<String> set = new HashSet<String>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        int count = 1;
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String current = q.poll();
                char[] temp = current.toCharArray();
                for(int j = 0; j < temp.length; j++){
                    char hold = temp[j];
                    for(char c = 'a'; c <= 'z'; c++ ){
                        temp[j] = c;
                        String next = new String(temp);
                        if(set.contains(next)){
                            if(endWord.equals(next)) return count + 1;
                            set.remove(next);
                            q.offer(next);
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
