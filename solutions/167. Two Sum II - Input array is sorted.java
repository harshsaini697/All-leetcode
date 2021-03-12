class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(numbers == null || numbers.length == 0 ) return new int[]{};
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], i + 1);
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                return new int[]{i + 1, map.get(target - numbers[i])};
            }
        }
        return new int[]{};
    }
}
