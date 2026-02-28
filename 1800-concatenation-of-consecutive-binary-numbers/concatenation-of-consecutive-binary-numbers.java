class Solution {
    public int concatenatedBinary(int n) {
           long result = 0;
        int M = 1_000_000_007;
        int digits = 0;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                digits++;
            }
            
            result = ((result << digits) % M + i) % M;
        }
        
        return (int) result;
    }
}