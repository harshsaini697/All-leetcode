class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        if(candidates == null || candidates.length == 0) return new ArrayList<>(res);
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    
    private void backtrack(int[] candidates, int target, List<Integer> temp, int index){
        
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(index == candidates.length){
            return;
        }
        //choose
        
        for(int i = index; i < candidates.length; i = nextLarger(candidates, i + 1)){
            //while(i < candidates.length && candidates[i] == candidates[i + 1]) continue;
            if(target < candidates[i]) break;
            temp.add(candidates[i]);
            backtrack(candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
        
​
    }
    private int nextLarger(int[] C, int i) {
        while (i < C.length && C[i] == C[i-1]) i++;
        return i;
    }
}
