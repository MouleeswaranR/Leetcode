class Solution {
    public int findGCD(int[] nums) {
        int maxElement=Integer.MIN_VALUE,minElement=Integer.MAX_VALUE;

        for(int num:nums){
            maxElement=Math.max(maxElement,num);
            minElement=Math.min(minElement,num);
        }

        return gcd(minElement,maxElement);
    }

    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }

        return a;
    }
}