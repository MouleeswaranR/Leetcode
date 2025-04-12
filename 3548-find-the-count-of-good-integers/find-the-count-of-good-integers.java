class Solution {
    private long kPalindromes = 0;
    private Set<Long> done = new HashSet<>();
    private long[] fact = new long[11];

    private void precomputeFactorial(int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i <= 10; ++i)
            fact[i] = i * fact[i - 1];
    }

    private long countAllPermutations(int[] freq, int n) {
        long count = fact[n];
        for (int i = 0; i <= 9; ++i)
            count /= fact[freq[i]];
        return count;
    }

    private long allArrangements(String number, int n) {
        char[] numArray = number.toCharArray();
        Arrays.sort(numArray);
        String sortedNumber = new String(numArray);
        long num = Long.parseLong(sortedNumber);
        if (done.contains(num))
            return 0;

        done.add(num);
        int[] freq = new int[10];
        for (char c : sortedNumber.toCharArray())
            freq[c - '0']++;

        long totalPermutations = countAllPermutations(freq, n);
        long invalidPermutations = 0;
        if (freq[0] > 0) {
            freq[0]--;
            invalidPermutations = countAllPermutations(freq, n - 1);
        }
        return totalPermutations - invalidPermutations;
    }

    private boolean isKPalindrome(String number, int n, int k) {
        return Long.parseLong(number) % k == 0;
    }

    private void generatePalindromes(int pos, int n, StringBuilder number, int k) {
        if (pos >= (n + 1) / 2) {
            String numStr = number.toString();
            if (isKPalindrome(numStr, n, k))
                kPalindromes += allArrangements(numStr, n);
            return;
        }

        char start = (pos == 0) ? '1' : '0';
        while (start <= '9') {
            number.setCharAt(pos, start);
            number.setCharAt(n - pos - 1, start);
            generatePalindromes(pos + 1, n, number, k);
            start++;
        }
        number.setCharAt(pos, ' ');
    }

    public long countGoodIntegers(int n, int k) {
        precomputeFactorial(n);
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < n; i++)
            number.append(' ');
        generatePalindromes(0, n, number, k);
        return kPalindromes;
    }
}