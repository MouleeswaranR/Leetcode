class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] diff=new int[n+1];
        for(int[] query:queries){
            int start=query[0];
            int end=query[1];
            diff[start]++;
            if(end+1<n){
                diff[end+1]--;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            if(sum<nums[i])return false;

        }
        return true;
    }
}