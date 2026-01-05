class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i=0,j=n,k=0;
        int[] ans=new int[nums.length];

        while(i<n && j<nums.length){
            ans[k++]=nums[i++];
            ans[k++]=nums[j++];
        }
        return ans;
    }
}