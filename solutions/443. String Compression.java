class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, index = 0;
        while(index < chars.length){
            int count = 0;
            char c = chars[index];
            while(index < chars.length && chars[index] == c){
                count++;
                index++;
            }
            chars[indexAns++] = c;
            if(count != 1){
                for(char d: Integer.toString(count).toCharArray()){
                    chars[indexAns++] = d;
                }
            }
        }
        return indexAns;
    }
}
