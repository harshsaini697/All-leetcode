class Solution {
    public String[] getFolderNames(String[] names) {
        if(names == null || names.length == 0) {
            return new String[0];
        }
        int len = names.length;
        String[] result = new String[len];
        HashMap<String, Integer> usedMap = new HashMap<>();
        for(int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder(names[i]);
            if(usedMap.containsKey(names[i])) {
                Integer val = usedMap.get(names[i]);
                while(usedMap.containsKey(sb.toString()) ) {
                    sb = new StringBuilder(names[i]);
                    sb.append('(');
                    sb.append(val);
                    sb.append(')');
                    val++;
                }
                result[i] = sb.toString();
                usedMap.put(result[i], 1);
                usedMap.put(names[i], val);
            } else {
                result[i] = names[i];
                usedMap.put(names[i], 1);
            }
        }
        return result;
    }
}
