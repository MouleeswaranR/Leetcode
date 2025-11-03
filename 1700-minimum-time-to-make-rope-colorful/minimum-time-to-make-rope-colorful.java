class Solution {
    public int minCost(String colors, int[] needTime) {
       int ans=0;
       for(int i=1;i<colors.length();i++){
        if(colors.charAt(i)==colors.charAt(i-1)){
            ans+=Math.min(needTime[i],needTime[i-1]);
            needTime[i]=Math.max(needTime[i],needTime[i-1]);
        }
       } 
       return ans;
    }
}