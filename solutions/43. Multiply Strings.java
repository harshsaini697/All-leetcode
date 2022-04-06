class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] pos = new int[len1 + len2];
        
        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pos.length; i++) {
            if(!(sb.length() == 0 && pos[i] == 0)) {
                sb.append(pos[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
