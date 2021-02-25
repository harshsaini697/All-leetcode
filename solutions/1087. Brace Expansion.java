class Solution {
    List<String> result;
    public String[] expand(String s) {
        result = new ArrayList<>();
        if(s == null || s.length() == 0) return new String[]{};
        List<List<Character>> blocks = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            List<Character> block = new ArrayList<>();
            if(s.charAt(i) == '{'){
                i++;
                while(s.charAt(i) != '}'){
                    if(s.charAt(i) != ','){
                        block.add(s.charAt(i));
                    }
                    i++;
                }
            }else{
                block.add(s.charAt(i));
            }
            blocks.add(block);
            i++;
        }
        backtrack( new StringBuilder(), 0, blocks);
        String[] res = new String[result.size()];
        for(int k = 0; k < result.size(); k++){
            res[k] = result.get(k);
        }
        Arrays.sort(res);
        return res;
        
    }
    private void backtrack(StringBuilder sb, int index,  List<List<Character>> blocks){
        //base
        if(index == blocks.size()){
            result.add(sb.toString());
            return;
        }
        
        //logic
        List<Character> block = blocks.get(index);
        for(int i = 0; i < block.size(); i++ ){
            //action
            sb.append(block.get(i));
            //recurse
            backtrack(sb, index + 1, blocks); 
            //backtrack
            sb.setLength(sb.length() - 1);
        }
    }
}
​
// {a,b} c {d,e}f
// if { then iterate over elements until } - backtrack - sb -[a]
// else append
