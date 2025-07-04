class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] hash=new int[26];
        if(sentence.length()<26)return false;
        for(int i=0;i<sentence.length();i++){
            hash[sentence.charAt(i)-'a']++;
        }
        for(int x:hash){
            if(x==0)return false;
        }
        return true;
    }
}