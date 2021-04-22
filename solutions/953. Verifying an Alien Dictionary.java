class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words == null || words.length == 0) return false;
        
        for(int i = 0; i < words.length - 1; i++){
            for(int j = 0; j < words[i].length(); j++){
                
                
                // Longer Ith word , smaller i+1
                if(j >= words[i + 1].length()) return false;
                
                if(words[i].charAt(j) != words[i + 1].charAt(j)){
                    if(order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))){
                        return false;
                    }else if(order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))){
                        break;
                    }
                }
            }
        }
        return true;
    }
}
