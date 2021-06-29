class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails == null) return 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++){
            String email = emails[i];
            String localname = email.split("@")[0];
            String domain = email.split("@")[1];
            StringBuilder sb = new StringBuilder();
            
            for(char c : localname.toCharArray()){
                if(c == '.'){
                    continue;
                }else if(c == '+'){
                    
                    break;
                }else{
                    sb.append(c);
                }
            }
            set.add(sb.toString() + "@" +domain);
        }
        return set.size();
    }
}
