class Solution {
    int M = 1_000_000_007;
    int[][] memo;

    String[] states = {
        "RYG", "RGY", "RYR", "RGR",
        "YRG", "YGR", "YGY", "YRY",
        "GRY", "GYR", "GRG", "GYG"
    };
    public int solve(int n,int prev){
        if(n==0)return 1;

        if(memo[n][prev]!=-1)return memo[n][prev];

        int result=0;
        String last=states[prev];
        for(int i=0;i<12;i++){
            if(i==prev)continue;

            String curr=states[i];
            boolean conflict=false;
            for(int j=0;j<3;j++){
                if(last.charAt(j)==curr.charAt(j)){
                    conflict=true;
                    break;
                }
            }
            if(!conflict){
                result=(result+solve(n-1,i))%M;
            }
        }
        return memo[n][prev]=result;
    }

    public int numOfWays(int n) {
        memo=new int[n][12];

        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }

        int result=0;

        for(int i=0;i<12;i++){
            result=(result+solve(n-1,i))%M;
        }
    return result;
}

}
