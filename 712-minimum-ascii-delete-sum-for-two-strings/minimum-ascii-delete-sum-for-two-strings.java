class Solution {
    public int solve(int idx1,int idx2,int len1,int len2,String s1,String s2,int[][] dp){
        if(idx1>=len1 && idx2>=len2){
            return 0;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(idx1>=len1){
            return dp[idx1][idx2]=s2.charAt(idx2)+solve(idx1,idx2+1,len1,len2,s1,s2,dp);
        }
         if(idx2>=len2){
            return dp[idx1][idx2]=s1.charAt(idx1)+solve(idx1+1,idx2,len1,len2,s1,s2,dp);
        }
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]=solve(idx1+1,idx2+1,len1,len2,s1,s2,dp);
        }
        int delStr1=s1.charAt(idx1)+solve(idx1+1,idx2,len1,len2,s1,s2,dp);
        int delStr2=s2.charAt(idx2)+solve(idx1,idx2+1,len1,len2,s1,s2,dp);
        return dp[idx1][idx2]=Math.min(delStr1,delStr2);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,s1.length(),s2.length(),s1,s2,dp);
    }
}