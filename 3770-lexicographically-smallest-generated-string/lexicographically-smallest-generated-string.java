class Solution {
    public String generateString(String str1, String str2) {
        int m=str1.length(),n=str2.length();

        int N=n+m-1;

        char[] word=new char[N];
        boolean[] canChange=new boolean[N];

        for(int i=0;i<N;i++){
            word[i]='$';
        }

        for(int i=0;i<m;i++){
            if(str1.charAt(i)=='T'){
                int idx=i;
                for(int j=0;j<n;j++){
                    if(word[idx]!='$' && word[idx]!=str2.charAt(j)){
                        return "";
                    }
                    word[idx]=str2.charAt(j);
                    idx++;
                }
              
            }
        }

        for(int i=0;i<N;i++){
            if(word[i]=='$'){
                word[i]='a';
                canChange[i]=true;
            }
        }

        for(int i=0;i<m;i++){
            if(str1.charAt(i)=='F'){
                if(isSame(word,str2,i,n)){
                    boolean changed=false;

                    for(int k=i+n-1;k>=i;k--){
                          if (canChange[k]) {
                            word[k] = 'b'; 
                            canChange[k] = false;
                            changed = true;
                            break;
                        }
                    }
                    if(!changed)return "";
                }
            }
        }
        return new String(word);
    }

    private boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) return false;
            i++;
        }
        return true;
    }
}