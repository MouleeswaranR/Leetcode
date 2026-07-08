class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length(),m=queries.length;
        long MOD = 1000000007L;

        long[] preSum=new long[n+1];
        long[] preVal=new long[n+1];
        int[] count=new int[n+1];
        long[] power=new long[n+1];
        power[0]=1;

        for(int i=1;i<=n;i++){
            power[i]=(power[i-1]*10)%MOD;
        }

        for(int i=0;i<n;i++){
            int digit=s.charAt(i)-'0';

            preSum[i+1]=preSum[i]+digit;
            count[i+1]=count[i]+(digit!=0?1:0);

            if(digit==0){
                preVal[i+1]=preVal[i];
            }else{
                preVal[i+1]=(preVal[i]*10+digit)%MOD;
            }

        }

        int[] result=new int[m];

        for(int i=0;i<m;i++){
            int left=queries[i][0],right=queries[i][1];

            int len=count[right+1]-count[left];

            long end=preVal[right+1],start=preVal[left];

            long x=(end-(start*power[len])%MOD+MOD)%MOD;

            long sum=preSum[right+1]-preSum[left];

            result[i]=(int)((x*sum)%MOD);
        }

        return result;
    }
}