class Solution {
    private int n;
    private int MOD=1_000_000_007;
    private int[][][] memo;

    public int solve(int idx,int gcd1,int gcd2,int[] nums){
        if(idx==n){
            return (gcd1!=0 && gcd1==gcd2)?1:0;
        }

        if(memo[idx][gcd1][gcd2]!=-1){
            return memo[idx][gcd1][gcd2];
        }

        long ans=0;

        ans=solve(idx+1,gcd1,gcd2,nums);

        int ng1=(gcd1==0)?nums[idx]:gcd(gcd1,nums[idx]);
        ans=(ans+solve(idx+1,ng1,gcd2,nums))%MOD;

        int ng2=(gcd2==0)?nums[idx]:gcd(gcd2,nums[idx]);
        ans=(ans+solve(idx+1,gcd1,ng2,nums))%MOD;

        return memo[idx][gcd1][gcd2]=(int)ans;

    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }
    public int subsequencePairCount(int[] nums) {
        n=nums.length;
        memo=new int[n+1][201][201];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=200;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }

        return solve(0,0,0,nums);
    }
}