class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        Character[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet(Arrays.asList(vowels));
        List<Character> vowel = new ArrayList<>();// vowel, index
        
        for(int i = 0; i < n; i++){
            if(set.contains(s.charAt(i))){
                vowel.add(s.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int j = vowel.size() - 1;
        for(int i = 0; i < n; i++){
            if(set.contains(s.charAt(i))){
                sb.append(vowel.get(j--));
            }else{
                sb.append(s.charAt(i));
            } 
        }
        
        return sb.toString();
    }
}
​
// a e i o u
// h e 
