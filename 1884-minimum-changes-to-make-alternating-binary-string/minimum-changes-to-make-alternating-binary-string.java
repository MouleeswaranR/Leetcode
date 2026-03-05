class Solution {
    public int minOperations(String s) {
        int n=s.length();

        int start_with_zero=0;

        for(int i=0;i<n;i++){
            if(i%2==0){
                if(s.charAt(i)=='1'){
                    start_with_zero++;
                }
            }else{
                 if(s.charAt(i)=='0'){
                    start_with_zero++;
                }
            }
        }

        return Math.min(start_with_zero,n-start_with_zero);
    }
}