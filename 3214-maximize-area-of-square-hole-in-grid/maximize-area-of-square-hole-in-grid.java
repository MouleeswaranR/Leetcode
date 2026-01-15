class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxHBars=1,maxVBars=1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int currHBars=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                currHBars++;
            }else{
                currHBars=1;
            }
            maxHBars=Math.max(maxHBars,currHBars);
        }

        int currVBars=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                currVBars++;
            }else{
                currVBars=1;
            }
            maxVBars=Math.max(maxVBars,currVBars);
        }

        int side=Math.min(maxHBars,maxVBars)+1;

        return side*side;

    }
}