class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long result=0;
        int count=0;

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int val:happiness)pq.offer(val);

        for(int i=0;i<k;i++){
            int val=pq.poll();
            result+=Math.max(val-count,0);
            count++;
        }
        return result;
    }
}