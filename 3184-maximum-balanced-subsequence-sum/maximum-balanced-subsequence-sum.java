//Recursion + Memoization
// class Solution {
//     public long solve(int i,int prev,int[] nums,Map<String,Long> memo){
//         if(i>=nums.length)return 0;

//         String key=i+"_"+prev;
//         if(memo.containsKey(key))return memo.get(key);

//         long taken=Integer.MIN_VALUE;
//         if(prev==-1||nums[i]-i>=nums[prev]-prev){
//             taken=nums[i]+solve(i+1,i,nums,memo);
//         }
//         long not_taken=solve(i+1,prev,nums,memo);
//         long result=Math.max(taken,not_taken);
//         memo.put(key,result);
//         return result;
//     }
//     public long maxBalancedSubsequenceSum(int[] nums) {
//         boolean allNegative=true;
//         long maxEl=Integer.MIN_VALUE;

//         for(int num:nums){
//             maxEl=Math.max(maxEl,num);
//             if(num>0){
//                 allNegative=false;
//             }
//         }
//         if(allNegative){
//             return maxEl;
//         }
//         Map<String,Long> memo=new HashMap<>();
//         return solve(0,-1,nums,memo);
//     }
// }

//Bottom-Up
// class Solution {
//     public long maxBalancedSubsequenceSum(int[] nums) {
//         boolean allNegative=true;
//         long maxEl=Integer.MIN_VALUE;

//         for(int num:nums){
//             maxEl=Math.max(maxEl,num);
//             if(num>0){
//                 allNegative=false;
//             }
//         }

//         long[] memo=new long[nums.length];
//         for(int i=0;i<nums.length;i++){
//             memo[i]=nums[i];
//         }
//         long sum=Integer.MIN_VALUE;

//         for(int i=0;i<nums.length;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[i]-i>=nums[j]-j){
//                 memo[i]=Math.max(memo[i],memo[j]+nums[i]);
//                 sum=Math.max(memo[i],sum);
//                 }
//             }
//         }
//         return maxEl>sum?maxEl:sum;
//     }
// }

class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=nums[i]-i;
        }
        long ans=Integer.MIN_VALUE;
        TreeMap<Integer,Long> map=new TreeMap<>();

        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                ans=Math.max(ans,nums[i]);
            }else{
                long temp=nums[i];
                if(map.floorKey(arr[i])!=null){
                    temp+=map.get(map.floorKey(arr[i]));
                }
                while(map.ceilingKey(arr[i])!=null && map.get(map.ceilingKey(arr[i]))<temp){
                    map.remove(map.ceilingKey(arr[i]));
                }
                if(map.floorKey(arr[i])==null||map.get(map.floorKey(arr[i]))<temp){
                    map.put(arr[i],temp);
                }
                ans=Math.max(ans,temp);
            }        
        }
        return ans;
    }
}