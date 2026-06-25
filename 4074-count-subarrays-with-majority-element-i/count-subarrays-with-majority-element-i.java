class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int[] preCount=new int[2*n+1];

        int result=0,validLeftPoints=0;
        int currSum=n;

        preCount[n]=1;

        for(int num:nums){
            if(num==target){
                validLeftPoints+=preCount[currSum];
                currSum++;
            }else{
                currSum--;
                validLeftPoints-=preCount[currSum];
            }

            preCount[currSum]++;
            result+=validLeftPoints;
        }

        return result;
    }
}