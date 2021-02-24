class Solution {
    public String arrangeWords(String text) {
        //base
        if(text == null || text.length() == 0) return text;
        text = text.toLowerCase();
        String[] texts = text.split(" ");
        
        //Main Fn Logic
        Arrays.sort(texts, (a, b) -> a.length() - b.length());
        
        // Modifying First Char to Upper Case
        char[] arr = texts[0].toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        texts[0] = String.valueOf(arr);
        
        //Result
        return String.join(" ", texts);
    }
}
​
//Leetcode is cool
​
//leetCode,is,cool
