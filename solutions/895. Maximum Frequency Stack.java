class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int max_freq;
    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        max_freq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        max_freq = Math.max(max_freq, f);
        group.putIfAbsent(f, new Stack());
        group.get(f).add(val);
    }
    
    public int pop() {
        int val = group.get(max_freq).pop();
        freq.put(val, max_freq - 1);
        if(group.get(max_freq).size() == 0) max_freq--;
        return val;
        
    }
}
​
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
