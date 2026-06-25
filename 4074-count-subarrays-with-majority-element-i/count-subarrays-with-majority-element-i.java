class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;

        int[] pre=new int[2*n+1];

        int ans=0,preSum=0,cnt=n;

        pre[n]=1;

        for(int num:nums){
            if(num==target){
                preSum+=pre[cnt];

                cnt++;
                pre[cnt]++;
            }else{
                cnt--;
                preSum-=pre[cnt];
                pre[cnt]++;
            }
            ans+=preSum;
        }

        return ans;
    }
}