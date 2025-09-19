class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans=0;
        for(String str:sentences){
            String[] curr=str.split(" ");
            ans=Math.max(ans,curr.length);
        }
        return ans;
    }
}