class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=1,n=nums.length;
        int count=0;
        while(j<n){
           if(nums[j]-nums[i]==k){
            count++;
            i++;
            j++;
            while(j<n && nums[j]==nums[j-1])j++;
           }else if(nums[j]-nums[i]>k){
            i++;
            if(j-i==0)j++;
           }else{
            j++;
           }
        }
        return count;
    }
}