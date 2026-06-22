class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq=new int[26];

        for(char ch:text.toCharArray()){
            freq[ch-'a']++;
        }

        int count=Integer.MAX_VALUE;
        count=Math.min(count,freq['b'-'a']);
        count=Math.min(count,freq['a'-'a']);
        count=Math.min(count,freq['l'-'a']/2);
        count=Math.min(count,freq['o'-'a']/2);
        count=Math.min(count,freq['n'-'a']);

        return count;
    }
}