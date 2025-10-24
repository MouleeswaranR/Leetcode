class Solution {
    public int nextBeautifulNumber(int n) {
        int num=n+1;
        while(!isNumericallyBalanced(num)){
            num++;
        }
        return num;
    }
    private boolean isNumericallyBalanced(int num){
        int[] digitCount=new int[10];
        while(num>0){
            int digit=num%10;
            digitCount[digit]++;
            num/=10;
        }
        for(int i=0;i<10;i++){
            if(digitCount[i]!=0 && digitCount[i]!=i){
                return false;
            }
        }
        return true;
    }
}