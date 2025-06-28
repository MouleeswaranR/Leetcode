class Solution {
    public int subtractProductAndSum(int n) {
        int pro=1,sum=0;
        while(n>0){
            int temp=n%10;
            pro*=temp;
            sum+=temp;
            n/=10;
        }
        return pro-sum;
    }
}