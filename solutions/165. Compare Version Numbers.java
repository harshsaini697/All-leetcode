class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length; int n2 = nums2.length;
        int v1, v2;
        for(int i = 0; i < Math.max(n1, n2); i++){
            v1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            v2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if(v1 != v2){
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }
}