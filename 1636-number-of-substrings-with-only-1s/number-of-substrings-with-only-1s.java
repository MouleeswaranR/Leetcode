class Solution {
    static final int MOD=1_000_000_007;
    public int numSub(String s) {
        long result=0;
        long count1=0;

        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count1++;
                result=(result+count1)%MOD;
            }else{
                count1=0;
            }
        }
        return (int)result;
    }
}