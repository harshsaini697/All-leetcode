class Solution {
    public String reformatDate(String date) {
        if(date == null || date.length() == 0) {
            return "";
        }
        
        HashMap<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        
        String[] splitDate = date.split(" ");
        String fmtDate = splitDate[0].split("[a-z]")[0].length() > 1 ?splitDate[0].split("[a-z]")[0] : "0" + splitDate[0].split("[a-z]")[0];
        
        String fmtMonth = splitDate[1];
        String fmtYear = splitDate[2];
        
        String mdfDate = fmtYear + "-" + map.get(fmtMonth) + "-" + fmtDate;
        
        return mdfDate;
    }
}
