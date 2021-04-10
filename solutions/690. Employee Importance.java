/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
​
class Solution {
    int ans = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(map, id);
        return ans;
    }
    private void dfs(HashMap<Integer, Employee> map, int id){
        
        Employee e = map.get(id);
        ans += e.importance;
        for(Integer sub: e.subordinates){
            dfs(map, sub);
        }
    }
}
