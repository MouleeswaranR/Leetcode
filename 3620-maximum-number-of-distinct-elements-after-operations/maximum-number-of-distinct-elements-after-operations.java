class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if(nums.length==0)return 0;
        Arrays.sort(nums);
        int prev=Integer.MIN_VALUE>>1;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int ele=nums[i];
            int low=ele-k,high=ele+k;
            int x=prev+1;
            if(x<low)x=low;
            if(x<=high){
                count++;
                prev=x;
            }
        }
        return count;
    }
}