class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        List<int[]> ans=new ArrayList<>();
       
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i][0]==nums2[j][0]){
                ans.add(new int[]{nums1[i][0],nums1[i++][1]+nums2[j++][1]});
            }else if(nums1[i][0]<nums2[j][0]){
                ans.add(nums1[i++]);
            }else{
                ans.add(nums2[j++]);
            }
        }
        while(i<nums1.length){
               ans.add(nums1[i++]);
        }
        while(j<nums2.length){
             ans.add(nums2[j++]);
        }
        int[][] result=new int[ans.size()][2];
        for( i=0;i<ans.size();i++)result[i]=ans.get(i);
        return result;
    }
}