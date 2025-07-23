class Solution {
    public int maxNonAdjSum(int[] nums){
        int n=nums.length;
        int prev=nums[0],prev2=0;
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1)pick+=prev2;
            int notPick=prev;
            int curr=Math.max(pick,notPick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        if(n==2)return Math.max(nums[0],nums[1]);
        if(n==1)return nums[0];
        for (int i = 1; i < n; i++) {
            temp1[i - 1] = nums[i]; 
        }
        for (int i = 0; i < n - 1; i++) {
            temp2[i] = nums[i]; 
        }
        return Math.max(maxNonAdjSum(temp1),maxNonAdjSum(temp2));
    }
}