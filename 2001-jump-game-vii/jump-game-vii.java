class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();

        int[] memo=new int[n];
        int count=0;

        memo[0]=1;

        for(int i=1;i<=n-1;i++){

            if(i-minJump>=0){
                count+=memo[i-minJump];
            }

            if(i-maxJump-1>=0){
                count-=memo[i-maxJump-1];
            }

            if(count>0 && s.charAt(i)=='0'){
                memo[i]=1;
            }
        }
        return memo[n-1]>0;
    }
}