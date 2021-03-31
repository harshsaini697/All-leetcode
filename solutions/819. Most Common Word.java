class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0) return "";
        
        String para = paragraph.toLowerCase();
        
        String[] paraArr = para.split("\\W+");
        
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String str: banned){
            set.add(str);
        }
        int count = 0;
        String res = "";
        for(int i = 0; i < paraArr.length; i++){
            //System.out.println(paraArr[i]);
            if(set.contains(paraArr[i])) continue;
            if(!map.containsKey(paraArr[i])){
                map.put(paraArr[i], 1);
                if(count < 1){
                    count = 1;
                    res = paraArr[i];
                }
            }else{
                int freq = map.get(paraArr[i]);
                map.put(paraArr[i], freq + 1);
                if(freq + 1 > count){
                    count = freq + 1;
                    res = paraArr[i];
                }
            }
        }
        return res;
    }
}
