class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans=new StringBuilder();
        for(char c:s.toCharArray()){
            int len=ans.length();
            if(len>=2 && ans.charAt(len-1)==c && ans.charAt(len-2)==c)continue;
            ans.append(c);
        }
        return ans.toString();
    }
}