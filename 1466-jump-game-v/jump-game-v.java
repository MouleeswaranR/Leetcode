class Solution {
    int n;
    int[] memo;

    public int solve(int[] arr,int d, int i){
        if(memo[i]!=-1)return memo[i];

        int result=1;

        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i])break;
            result=Math.max(result,1+solve(arr,d,j));
        }

        for(int j=i+1;j<=Math.min(n-1,i+d);j++){
             if(arr[j]>=arr[i])break;
            result=Math.max(result,1+solve(arr,d,j));
        }

        return memo[i]=result;
    }

    public int maxJumps(int[] arr, int d) {
        n=arr.length;
        memo=new int[n];
        Arrays.fill(memo,-1);

        int maxResult=1;

        for(int i=0;i<n;i++){
            maxResult=Math.max(maxResult,solve(arr,d,i));
        }

        return maxResult;
    }
}