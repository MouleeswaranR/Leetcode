class Solution {
int memo[2501][2501];
public:
    int solve(vector<int>& nums,int idx,int prev){
        if(idx==nums.size())return 0;

        if(prev!=-1 && memo[idx][prev]!=-1){
            return memo[idx][prev];
        }
        int take=0;
        if(prev==-1 || nums[prev]<nums[idx]){
            take=1+solve(nums,idx+1,idx);
        }

        int skip=solve(nums,idx+1,prev);
        if(prev!=-1){
             memo[idx][prev]= max(take,skip);
        }
        return max(take,skip);
    }
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        memset(memo,-1,sizeof(memo));
        return solve(nums,0,-1);
    }
};