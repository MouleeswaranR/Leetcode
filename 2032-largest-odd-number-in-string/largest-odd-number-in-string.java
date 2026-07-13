class Solution {
    public String largestOddNumber(String nums) {
        // int oddIndex=-1;

        // for(int i=0;i<nums.length();i++){
        //     int num=nums.charAt(i)-'0';
        //     if((num&1)==1)oddIndex=i;
        // }

        // return oddIndex==-1?"":nums.substring(0,oddIndex+1);

        int n=nums.length();

        for(int i=n-1;i>=0;i--){
            if((nums.charAt(i)-'0')%2==1)return nums.substring(0,i+1);
        }
        return "";
    }
}