class Solution {
    public long sumAndMultiply(int n) {
        long x=0,sum=0,place=1;

        while(n>0){
            int rem=n%10;
            if(rem!=0){
                x=rem*place+x;
                place*=10;
                sum+=rem;
            }
            n=n/10;
        }

        return x*sum;
    }
}