 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int sum = 0;
    int level = 1;
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        recurse(nestedList, level);
        return sum;
    }
    
    private void recurse(List<NestedInteger> nestedList, int level) {
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger n = nestedList.get(i); 
            if(n.isInteger()) {
                this.sum += level * n.getInteger();
            } else {
                recurse(n.getList(), level + 1);
            }
        }
    }
}
