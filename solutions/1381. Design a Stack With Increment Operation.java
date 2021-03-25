class CustomStack {
    int cap;
    Stack<Integer> st;
    public CustomStack(int maxSize) {
        cap = maxSize;
        st = new Stack();
    }
    
    public void push(int x) {
        if(st.size() == cap){
            return;
        }
        st.push(x);
    }
    
    public int pop() {
        if(st.size() == 0) return -1;
        return st.pop();
    }
    
    public void increment(int k, int val) {
        //System.out.println(st);
        ArrayList<Integer> al = new ArrayList<>();
        // int limit = st.size() < k ? st.size() : k;
        // for(int i = 0; i < st.size(); i++){
        //     al.add(st.pop());
        // }
        // for(int i = st.size() - 1; i >= st.size() - k; i--){
        //     int value = al.get(i);
        //     al.set(i, value + val);
        // }
        // for(int i = al.size(); i > 0; i--){
        //     int j = al.remove(al.size() - 1);
        //     st.push(j);
        // }
        while(!st.isEmpty()){
            al.add(st.pop());
        }
        //System.out.println(al);
        //int limit = al.size()  < k ? al.size() : k;
        if(al.size() <= k){
           for(int i = 0; i < al.size(); i++){
            int value = al.get(i);
            al.set(i, value + val);
            } 
        }else{
            for(int i = al.size() - k; i < al.size(); i++){
                int value = al.get(i);
                al.set(i, value + val);
            }
        }
        for(int i = al.size();i > 0; i--){
            int j = al.remove(al.size() -1);
            st.push(j);
        }
        al = new ArrayList<>();
    }
}
​
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
