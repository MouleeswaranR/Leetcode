class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3;
        int total=3*n;

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        long[] left=new long[total];
        for(int i=0;i<total;i++){
            maxHeap.offer(nums[i]);
            sum+=nums[i];
            if(maxHeap.size()>n)sum-=maxHeap.poll();
            if(i>=n-1)left[i]=sum;
        }
          PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        sum=0;
        long[] right=new long[total];
        for(int i=total-1;i>=0;i--){
            minHeap.offer(nums[i]);
            sum+=nums[i];
            if(minHeap.size()>n)sum-=minHeap.poll();
            if(i<=2*n)right[i]=sum;
        }
        Long res=Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            res=Math.min(res,left[i]-right[i+1]);
        }
        return res;
    }
}