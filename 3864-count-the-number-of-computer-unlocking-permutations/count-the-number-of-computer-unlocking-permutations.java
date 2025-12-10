class Solution {
    public static final int MOD= 1000000007;
    public int countPermutations(int[] complexity) {
        int n=complexity.length;

        long result=1;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0])return 0;
            result=(result*i)%MOD;
        }
        return (int)result;
    }
}