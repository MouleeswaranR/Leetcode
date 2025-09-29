class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookieLen=s.length;
        if(cookieLen==0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int maxNum=0,cookieInd=cookieLen-1,childInd=g.length-1;
        while(cookieInd>=0 && childInd>=0){
            if(s[cookieInd]>=g[childInd]){
                maxNum++;
                cookieInd--;
                childInd--;
            }else{
                childInd--;
            }
        }
        return maxNum;
    }
}