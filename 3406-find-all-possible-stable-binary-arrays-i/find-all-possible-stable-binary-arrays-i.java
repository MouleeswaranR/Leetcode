class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD=1_000_000_007;
        int[][][] memo=new int[one+1][zero+1][2];

        memo[0][0][0]=1;
        memo[0][0][1]=1;


        for(int zerosLeft=0;zerosLeft<=zero;zerosLeft++){
            for(int onesLeft=0;onesLeft<=one;onesLeft++){
                if(zerosLeft==0 && onesLeft==0)continue;

                int result=0;
                for(int i=1;i<=Math.min(limit,zerosLeft);i++){
                    result=(result+memo[onesLeft][zerosLeft-i][0])%MOD;
                }
                memo[onesLeft][zerosLeft][1]=result;

                result=0;

                for(int i=1;i<=Math.min(limit,onesLeft);i++){
                    result=(result+memo[onesLeft-i][zerosLeft][1])%MOD;
                }
                memo[onesLeft][zerosLeft][0]=result;
            }
        }
        int startWithZero=memo[one][zero][0];
        int startWihOne=memo[one][zero][1];

        return (startWithZero+startWihOne)%MOD;
    }
}