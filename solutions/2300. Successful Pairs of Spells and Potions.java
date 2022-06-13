class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] spellsCopy = spells.clone();
        Arrays.sort(spells);
        Arrays.sort(potions);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int m = spells.length;
        int n = potions.length;
        int j = n - 1;
        for (int i = 0; i < m; i++) {
            while (j >= 0 && (1L * potions[j] * spells[i] >= success)) {
                j--;
            }
            map.put(spells[i], n - j - 1);
        }
        int[] res = new int[spells.length];
        for(int i = 0; i < spells.length; i++) {
            res[i] = map.get(spellsCopy[i]);
        }
        return res;
    }
}
