class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        Map<Integer,Integer> cumSum=new HashMap<>();

        int currSum=0;

        long validLeftPoints=0;
        long result=0;

        cumSum.put(0,1);

        for(int num:nums){
            if(num==target){
                validLeftPoints+=cumSum.getOrDefault(currSum,0);
                currSum++;
            }else{
                currSum--;
                validLeftPoints-=cumSum.getOrDefault(currSum,0);
            }
            cumSum.put(currSum,cumSum.getOrDefault(currSum,0)+1);
            result+=validLeftPoints;
        }
        return result;
    }
}