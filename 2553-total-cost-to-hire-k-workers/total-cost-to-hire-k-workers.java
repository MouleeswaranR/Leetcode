class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        //given costs for each worker in index i of costs, select  candidates no of workers in each session of k
        long ans=0;

        PriorityQueue<Integer> pq1=new PriorityQueue<>();//stores first "candidates" no of candidates(who have lowest cost on top from front)
        PriorityQueue<Integer> pq2=new PriorityQueue<>();//stores last "candidates" no of candidates(who have lowest cost on top from last)

        int hired=0;//to check k sessions
        int i=0,j=costs.length-1;//points to move from front and last

        while(hired<k){
            
            //NOTE::
            //always use i<=j check for heap1 and j>=i check for heap2 to prevent overlapping issue in costs array(avoiding same index getting pushed into both heaps)

            //push "candidates" no of candidates cost from front and 
            while(pq1.size()<candidates && i<=j){
                pq1.offer(costs[i]);
                i++;
            }

            //push "candidates" no of candidates cost from back
            while(pq2.size()<candidates && j>=i){
                pq2.offer(costs[j]);
                j--;
            }

            //check which heap have smallest, if both of the top are equal always use heap1 because question asked to take value with lowest index if both are same
            int min_pq1=pq1.size()>0?pq1.peek():Integer.MAX_VALUE;
            int min_pq2=pq2.size()>0?pq2.peek():Integer.MAX_VALUE;

            //if top of heap1 is small or equal than top of heap2,poll from heap1 else from heap2
            if(min_pq1<=min_pq2){
                ans+=pq1.poll();
            }else{
                ans+=pq2.poll();
            }

            hired++;//increment session count (k count)
        }

        return ans;
    }
}