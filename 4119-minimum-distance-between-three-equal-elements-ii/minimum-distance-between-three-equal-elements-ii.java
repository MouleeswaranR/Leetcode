class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;

        Map<Integer,List<Integer>> map=new HashMap<>();

        int result=n;

        for(int k=0;k<n;k++){
            map.putIfAbsent(nums[k],new ArrayList<>());
            map.get(nums[k]).add(k);

            if(map.get(nums[k]).size()>=3){
                List<Integer> list=map.get(nums[k]);
                int size=list.size();
                int i=list.get(size-3);
                result=Math.min(result,k-i);
            }
        }

        return result>=n?-1:2*result;
    }
}