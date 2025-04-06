class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int lis=1;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    if(lis<dp[i]){
                        lis=dp[i];
                    }
                }
            }
        }
        int prev=-1;
        for(int i=n-1;i>=0;i--){
            if(dp[i]==lis&&(prev==-1||prev%nums[i]==0)){
                ans.add(nums[i]);
                lis--;
                prev=nums[i];
            }
        }
        return ans;
    }
}