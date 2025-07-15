class Solution {
    public boolean isValid(String word) {
        if(word.length()<3)return false;
        boolean vowel=false,cons=false;
        for(char ch:word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            char lc=Character.toLowerCase(ch);
            if(lc=='a'||lc=='e'||lc=='i'||lc=='o'||lc=='u'){
                vowel=true;
            }else if(Character.isLetter(lc)){
                cons=true;
            }
        }
        return vowel&&cons;
    }
}