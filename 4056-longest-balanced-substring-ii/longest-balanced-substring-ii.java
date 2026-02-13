class Solution {
    static class Pair {
        int d1, d2;

        Pair(int d1, int d2) {
            this.d1 = d1;
            this.d2 = d2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return d1 == p.d1 && d2 == p.d2;
        }

        @Override
        public int hashCode() {
            return 31 * d1 + d2;
        }
    }
    public int helper(char[] c, char x, char y) {

        int n = c.length;
        int max_len = 0;

        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clear_idx = -1;
        int diff = n;

        first[diff] = -1;

        for (int i = 0; i < n; i++) {

            if (c[i] != x && c[i] != y) {

                clear_idx = i;
                diff = n;
                first[diff] = clear_idx;

            } else {

                if (c[i] == x) diff++;
                else diff--;

                if (first[diff] < clear_idx) {
                    first[diff] = i;
                } else {
                    max_len = Math.max(max_len, i - first[diff]);
                }
            }
        }

        return max_len;
    }
    public int longestBalanced(String s) {
        char[] c =s.toCharArray();
        int n=s.length();
        int maxL=0;
        if(n==1)return 1;

        int count=1;

        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                maxL=Math.max(maxL,count);
                count=1;
            }
        }
        maxL=Math.max(maxL,count);

        maxL=Math.max(maxL,helper(c,'a','b'));
        maxL=Math.max(maxL,helper(c,'b','c'));
        maxL=Math.max(maxL,helper(c,'a','c'));

        Map<Pair,Integer> map=new HashMap<>();
        int ca=0,cb=0,cc=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')ca++;
            else if(s.charAt(i)=='b')cb++;
            else cc++;

            if(ca==cb && ca==cc){
                maxL=Math.max(maxL,ca+cb+cc);
            }

            Pair key=new Pair(ca-cb,ca-cc);

            Integer prev=map.get(key);

            if(prev!=null){
                maxL=Math.max(maxL,i-prev);
            }else{
                map.put(key,i);
            }
        }
        return maxL;
    }
}