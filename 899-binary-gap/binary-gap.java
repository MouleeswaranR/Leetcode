class Solution {
    public int binaryGap(int n) {
        int prev=-1;
        int result=0;


        for(int i=0;i<32;i++){
            if(((n>>i)&1)>0){
                result=(prev!=-1)?Math.max(result,i-prev):result;
                prev=i;
            }
        }
        return result;
    }
}