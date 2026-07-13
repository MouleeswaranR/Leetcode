class Solution {
    public String largestOddNumber(String nums) {
        int oddIndex=-1;

        for(int i=0;i<nums.length();i++){
            int num=nums.charAt(i)-'0';
            if(num%2==1)oddIndex=i;
        }

        return oddIndex==-1?"":nums.substring(0,oddIndex+1);
    }
}