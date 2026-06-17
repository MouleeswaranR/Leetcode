class Solution {
    public char processStr(String s, long k) {
        int n=s.length();

        long len=0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);

            if(ch=='*'){
                if(len>0){
                    len--;
                }
            }else if(ch=='#'){
                len*=2;
            }else if(ch=='%'){
                continue;
            }else{
                len++;
            }
        }

        if(k>=len)return '.';


        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);

            if(ch=='*'){
                len++;
            }else if(ch=='%'){
                k=len-k-1;
            }else if(ch=='#'){
                len=len/2;
                k=(k>=len)?k-len:k;
            }else{
                len--;
            }

            if(k==len)return ch;
        }

        return '.';
    }
}