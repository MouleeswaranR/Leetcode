class Solution {
    static final long NEG_INF=Long.MIN_VALUE/2;
    public long maxSumTrionic(int[] nums) {
        int n=nums.length;
        long[][] memo=new long[n][4];

        for(int i=0;i<n;i++)Arrays.fill(memo[i],Long.MIN_VALUE);

        return solve(0,0,nums,memo);
    }

    public long solve(int index,int trend,int[] nums,long[][] memo){
        if(index==nums.length){
            return trend==3?0:NEG_INF;
        }

        if(memo[index][trend]!=Long.MIN_VALUE){
            return memo[index][trend];
        }

        long take=NEG_INF;
        long skip=NEG_INF;

        if(trend==0){
            skip=solve(index+1,0,nums,memo);
        }

        if(trend==3){
            take=nums[index];
        }

        if(index+1<nums.length){
            int curr=nums[index],next=nums[index+1];

            if(trend==0 && curr<next){
                take=Math.max(take,nums[index]+solve(index+1,1,nums,memo));
            }else if(trend==1){
                if(curr<next){
                    take=Math.max(take,nums[index]+solve(index+1,1,nums,memo));
                }else if(next<curr){
                    take=Math.max(take,nums[index]+solve(index+1,2,nums,memo));
                }
            }else if(trend==2){
                if(curr<next){
                    take=Math.max(take,nums[index]+solve(index+1,3,nums,memo));
                }else if(next<curr){
                    take=Math.max(take,nums[index]+solve(index+1,2,nums,memo));
                }
            }else if(trend==3 && curr<next){
                take=Math.max(take,nums[index]+solve(index+1,3,nums,memo));
            }
        }
        return memo[index][trend]=Math.max(take,skip);
    }
}