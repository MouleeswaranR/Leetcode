class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length()-1;i++){
                int frchar=s.charAt(i)-'0';
                int scchar=s.charAt(i+1)-'0';
                int newchar=(frchar+scchar)%10;
                sb.append(newchar);
            }
            s=sb.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}