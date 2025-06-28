class Solution {
    public int[] numberGame(int[] nums) {
        int n=nums.length;
        List<Integer> arr=new ArrayList<>();
        int[] ans=new int[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)pq.add(nums[i]);
        while(!pq.isEmpty()){
            int alice=pq.poll();
            int bob=pq.poll();
            arr.add(bob);
            arr.add(alice);
        }
        for(int i=0;i<n;i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
}