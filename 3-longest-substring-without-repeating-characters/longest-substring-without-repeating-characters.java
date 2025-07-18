class Solution {
    public int lengthOfLongestSubstring(String s) {
       int left=0,right=0,maxlen=0;
       int[] vis=new int[256];
       while(right<s.length()){
        char ch=s.charAt(right);
        vis[ch]++;
        while(vis[ch]>1){
            vis[s.charAt(left)]--;
            left++;
        }
        maxlen=Math.max(maxlen,right-left+1);
        right++;
         }
         return maxlen;
    }
}