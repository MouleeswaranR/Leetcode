class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=prices.length;

        long[] profit=new long[n];
        long actualProfit=0;

        for(int i=0;i<n;i++){
            profit[i]=(long)(prices[i]*strategy[i]);
            actualProfit+=profit[i];
        }

        long origWinProfit=0;
        long modifiedWinProfit=0;
        long maxGain=0;

        int i=0,j=0;

        while(j<n){
            origWinProfit+=profit[j];

            if(j-i+1>k/2){
                modifiedWinProfit+=prices[j];
            }

            if(j-i+1>k){
                origWinProfit-=profit[i];
                modifiedWinProfit-=prices[i+k/2];
                i++;
            }
            if(j-i+1==k){
                maxGain=Math.max(maxGain,modifiedWinProfit-origWinProfit);
            }
            j++;
        }
        return actualProfit+maxGain;
    }
}