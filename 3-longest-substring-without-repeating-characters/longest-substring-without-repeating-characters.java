class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if(len==0||len==1)return len;
        int i=0,j=0;
        int maxLen=Integer.MIN_VALUE;
        Set<Character> set=new HashSet<>();
        while(i<len){

            while(j<len && set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLen=Math.max(maxLen,i-j+1);
            i++;
        }

        return maxLen;
    }
}