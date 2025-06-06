class Solution {
    public int findNumbers(int[] nums) {
         int count=0;
        for(int num:nums){
            if(isEven(num)){
                count++;
            }
        
        }
        return count;
    }
    boolean isEven(int num){
        int digits=noDigits(num);
        return digits%2==0;
    }
    int noDigits(int num){
    if(num<0) num=num*-1;
     if(num==0) return 1;
     int count=0;
     while(num>0){
        count++;
        num/=10;
     }
     return count;
    }
}
