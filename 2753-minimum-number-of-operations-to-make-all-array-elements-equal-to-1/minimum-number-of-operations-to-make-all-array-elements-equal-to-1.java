class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ones=0;
        for(int num:nums){
            if(num==1)ones++;
        }
        if(ones>0){
            return n-ones;
        }
        int operations=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int gcdVal=nums[i];
            for(int j=i+1;j<n;j++){
                gcdVal=gcd(gcdVal,nums[j]);
             if (gcdVal == 1) {
                operations = Math.min(operations, j - i);
                break;
            }
            }
        }
        if(operations==Integer.MAX_VALUE)return -1;
        return operations+(n-1);
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