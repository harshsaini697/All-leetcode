class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // we need to do bucket sort
        
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < words.length; i++) {
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
