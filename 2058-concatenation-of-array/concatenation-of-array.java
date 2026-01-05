class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int totalLen=2*n;

        int[] ans=new int[totalLen];

        for(int i=0;i<n;i++){
            ans[i]=nums[i];
        }

        for(int i=n;i<totalLen;i++){
            ans[i]=nums[i-n];
        }
        return ans;
    }
}