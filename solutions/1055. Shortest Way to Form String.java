class Solution {
    public int shortestWay(String source, String target) {
        int count = 0;
        int i = 0;
        while(i < target.length()){
            int j = 0;
            if(source.indexOf(target.charAt(i)) == -1) return -1;
            while(j < source.length() && i < target.length()){
                if(source.charAt(j) == target.charAt(i)){
                    i++;
                }
                j++;
            }
            count++;
        }
        return count;
    }
}
