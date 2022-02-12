class Solution {
    List<String> permutations;
    public List<String> letterCasePermutation(String s) {
        permutations = new ArrayList<>();
        s = s.toLowerCase();
        helper(s.toCharArray(), 0);
        permutations.add(s);
        return permutations;
    }
    
    private void helper(char[] sequence, int index) {
        for(int i = index; i < sequence.length; i++) {
            char c = sequence[i];
            if(!Character.isDigit(c)) {
                sequence[i] = Character.toUpperCase(c);
                permutations.add(String.valueOf(sequence));
                helper(sequence, i + 1);
                sequence[i] = c;
            }
        }
    }
}
