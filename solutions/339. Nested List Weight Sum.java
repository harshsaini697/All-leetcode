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
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger n = nestedList.get(i);
            if(n.getList().size() == 0) {
                sum += (n.getInteger() == null ? 0: n.getInteger());
            } else {
                recurse(n.getList(), level + 1);
            }
        }
        return sum;
    }
    
    private void recurse(List<NestedInteger> nestedList, int level) {
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger n = nestedList.get(i); 
            if(n.getList().size() == 0) {
                this.sum += level *(n.getInteger() == null ? 0: n.getInteger());
            } else {
                recurse(n.getList(), level + 1);
            }
        }
    }
}
