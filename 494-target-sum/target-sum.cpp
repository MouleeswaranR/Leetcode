class Solution {
    int sum;

public:
    int solve(vector<int>& nums,int& target,int index,int currSum,vector<vector<int>>& memo){
        if(index==nums.size()){
            return currSum==target?1:0;
        }
        if(memo[index][currSum+sum]!=INT_MIN){
            return memo[index][currSum+sum];
        }
        int plus=solve(nums,target,index+1,currSum+nums[index],memo);
        int minus=solve(nums,target,index+1,currSum-nums[index],memo);

        return memo[index][currSum+sum]=plus+minus;
    }
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        sum=accumulate(begin(nums),end(nums),0);
        int n=nums.size();
        vector<vector<int>> memo(n,vector<int>(2*sum+1,INT_MIN));
        return solve(nums,target,0,0,memo);
    }
};