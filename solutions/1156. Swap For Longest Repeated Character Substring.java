class Solution {
    public int maxRepOpt1(String text) {
        if(text == null || text.length() == 0) return 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < text.length() ; i++){
            char c = text.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        //System.out.println(map.values());
        int res = 0;
        for(List<Integer> list: map.values()){
            int size = list.size();
            int curr = 1;int prev = 0;int sum = 1;
            for(int i = 1; i < size; i++){
                if(list.get(i)  == list.get(i - 1) + 1){
                    curr++;
                }else{
                    //not contiguous
                    prev = list.get(i - 1) + 2 == list.get(i) ? curr : 0; 
                    curr = 1;
                }
                sum = Math.max(sum, prev + curr);
            }
            res = Math.max(res, sum + (sum < size ? 1: 0)); // we can swap one element if sum comes lesser than list size
        }
        return res;
    }
}
​
​
// a b a b a
// 
