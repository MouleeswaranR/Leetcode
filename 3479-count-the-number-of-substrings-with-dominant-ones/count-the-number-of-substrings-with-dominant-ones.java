class Solution {
    public int numberOfSubstrings(String s) {

        int n = s.length();
        int[] cumCountOne = new int[n];

        cumCountOne[0] = (s.charAt(0) == '1') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            cumCountOne[i] = cumCountOne[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                int oneCount = cumCountOne[j] - (i > 0 ? cumCountOne[i - 1] : 0);
                int zeroCount = (j - i + 1) - oneCount;

                int z2 = zeroCount * zeroCount;

                if (z2 > oneCount) {
                    int waste = z2 - oneCount;
                    j += waste - 1;

                } else if (z2 == oneCount) {
                    result++;

                } else {
                    result++;

                    int k = (int) Math.sqrt(oneCount) - zeroCount;
                    int next = j + k;

                    if (next >= n) {
                        result += (n - j - 1);
                        break;
                    } else {
                        result += k;
                    }

                    j = next;
                }
            }
        }

        return result;
    }
}