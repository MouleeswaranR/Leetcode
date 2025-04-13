class Solution {
    final int MOD = 1000000007;

    private long binaryExponentiation(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public int countGoodNumbers(long n) {
        return (int)((binaryExponentiation(4, n / 2) * binaryExponentiation(5, n - n / 2)) % MOD);
    }
}