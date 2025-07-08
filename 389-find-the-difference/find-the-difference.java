class Solution {
    public char findTheDifference(String s, String t) {
        char ans=0;
        for(char ch:s.toCharArray())ans^=ch;
        for(char ch:t.toCharArray())ans^=ch;
    return ans;
    }
}