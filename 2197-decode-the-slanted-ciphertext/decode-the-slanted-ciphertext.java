class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int length=encodedText.length();

        int columns=length/rows;


        StringBuilder orgText=new StringBuilder();


        for(int col=0;col<columns;col++){
            for(int j=col;j<length;j+=(columns+1)){
                orgText.append(encodedText.charAt(j));
            }
        }

        while(orgText.length()>0 && orgText.charAt(orgText.length()-1)==' '){
            orgText.deleteCharAt(orgText.length()-1);
        }

        return orgText.toString();
    }
}