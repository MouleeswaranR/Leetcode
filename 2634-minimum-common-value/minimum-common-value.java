class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;

        int i=0,j=0;
        int result=-1;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                result=nums1[i];
                break;
            }
        }
        return result;
    }
}