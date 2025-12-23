class Solution {
    private int n;
    private int[][] dp=new int[100001][3];

    public int binarySearch(int[][] events,int endTime){
        int left=0,right=n-1,result=n;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(events[mid][0]>endTime){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    public int solve(int[][] events,int ind,int count){
        if(count==2||ind>=n){
            return 0;
        }

        if(dp[ind][count]!=-1){
            return dp[ind][count];
        }

        int nextValidInd=binarySearch(events,events[ind][1]);
        int take=events[ind][2]+solve(events,nextValidInd,count+1);
        int notTake=solve(events,ind+1,count);

        dp[ind][count]=Math.max(take,notTake);

        return dp[ind][count];
    }
    public int maxTwoEvents(int[][] events) {
        n=events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(events,0,0);
    }
}