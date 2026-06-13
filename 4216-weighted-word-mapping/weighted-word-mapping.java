class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result=new StringBuilder(words.length);

        for(String str:words){
            int temp=0;
            for(int i=0;i<str.length();i++){
                temp+=weights[(str.charAt(i)-'a')];
            }

            result.append((char)('z'-(temp%26)));
        }

        return result.toString();
    }
}