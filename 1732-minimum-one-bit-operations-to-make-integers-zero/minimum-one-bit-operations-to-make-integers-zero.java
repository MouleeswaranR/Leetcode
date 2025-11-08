class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0)return 0;

        int[] bits=new int[32];
       
        bits[0]=1;
        for(int i=1;i<=31;i++){
            bits[i]=2*bits[i-1]+1;
        }
        int result=0;
        int sign=1;
        for(int i=30;i>=0;i--){
            int ith_bit=n&(1<<i);

            if(ith_bit==0)continue;

            if(sign>0){
                result+=bits[i];
            }else{
                result-=bits[i];
            }
            sign*=-1;
        }
        return result;
    }
}