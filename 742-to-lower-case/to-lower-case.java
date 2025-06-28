class Solution {
    public String toLowerCase(String s) {
        int n=s.length();
        String result="";
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int temp=(int)c;
            if(65<=temp && temp<=90){
                int a=temp-65+97;
                result+=(char)a;
            }else{
                result+=c;
            }
        }
        return result;
    }
}