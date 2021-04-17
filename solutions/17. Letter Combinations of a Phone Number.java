class Solution {
    List<String> res;
    Map<String, List<String>> map;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        map = new HashMap<>();
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y","z"));
        //System.out.println(map);
        backtrack(digits, 0, new StringBuilder());
        return res;
    }
    private void backtrack(String digits, int index, StringBuilder sb){
        
        if(sb.length() == digits.length()){
            res.add(new String(sb.toString()));
        }
        if(index == digits.length()){
            return;
        }
        //logic
        for(int i = index; i < digits.length(); i++){
            List<String> a = map.get(String.valueOf(digits.charAt(i)));
            //System.out.println(a);
            for(int j = 0; j < a.size(); j++){
                sb.append(a.get(j));
                backtrack(digits, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
