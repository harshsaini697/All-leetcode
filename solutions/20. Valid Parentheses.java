class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('}', '{');
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        
        Stack<Character> openingLiteralStack = new Stack();
        
        for(char c: s.toCharArray()) {
            if(!bracketMap.containsKey(c)) {
                openingLiteralStack.push(c);
            } else {
                if(!openingLiteralStack.isEmpty() && openingLiteralStack.peek() == bracketMap.get(c)) {
                    openingLiteralStack.pop();
                } else {
                    return false;
                }
            }
        }
        return openingLiteralStack.isEmpty();
    }
}
