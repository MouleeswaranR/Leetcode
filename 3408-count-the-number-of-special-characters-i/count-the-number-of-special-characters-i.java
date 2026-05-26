class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        Set<Character> lower=new HashSet<>(),upper=new HashSet<>();


        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch))lower.add(ch);
            else upper.add(Character.toLowerCase(ch));
        }

        for(char ch:lower){
            if(upper.contains(ch)){
                count++;
            }
        }

        return count;
    }
}