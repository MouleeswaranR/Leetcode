class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;

        int[] memo=new int[n+1];

        Arrays.fill(memo,Integer.MIN_VALUE);

        memo[n-1]=0;
        
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(Math.abs(nums[i]-nums[j])<=target && memo[j]!=Integer.MIN_VALUE){
                    int temp=1+memo[j];

                    memo[i]=Math.max(memo[i],temp);
                }
            }
        }

        return memo[0]<0?-1:memo[0];
    }
}