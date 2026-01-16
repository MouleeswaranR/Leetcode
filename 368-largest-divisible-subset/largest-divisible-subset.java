// //Recursion
// //Time Complexity: O(2^n)
// class Solution {

//     public void generate(int idx,int[] nums,List<Integer> result,List<Integer> temp,int prev){
//         if(idx>=nums.length){
//             if(temp.size()>=result.size()){
//                 result.clear();
//                 result.addAll(temp);
//             }
//             return;
//         }

//         if(prev==-1||nums[idx]%prev==0){
//             temp.add(nums[idx]);
//             generate(idx+1,nums,result,temp,nums[idx]);
//             temp.remove(temp.size()-1);
//         }
//         generate(idx+1,nums,result,temp,prev);
//     }
//     public List<Integer> largestDivisibleSubset(int[] nums) {
        
//         Arrays.sort(nums);
//         List<Integer> result=new ArrayList<>();
//         List<Integer> temp=new ArrayList<>();

//         generate(0,nums,result,temp,-1);
//         return result;
//     }
// }

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] prevIdx=new int[n];
        Arrays.fill(prevIdx,-1);

        int maxL=1;
        int lastSeenIdx=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        prevIdx[i]=j;
                    }
                    if(dp[i]>maxL){
                        maxL=dp[i];
                        lastSeenIdx=i;
                    }
                }
            }
        }

        List<Integer> ans=new ArrayList<>();

        while(lastSeenIdx>=0){
            ans.add(nums[lastSeenIdx]);
            lastSeenIdx=prevIdx[lastSeenIdx];
        }

        return ans;
    }
}