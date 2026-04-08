class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int M=(int)1e9+7;
        for(int[] query:queries){
            int l=query[0],r=query[1],k=query[2],v=query[3];

            while(l<=r){
                nums[l]=(int)((1L*nums[l]*v)%M);
                l+=k;
            }


        }

        int result=0;

        for(int num:nums){
            result^=num;
        }

        return result;
    }
}