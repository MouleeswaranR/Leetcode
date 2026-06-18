class Solution {
    public int minStoneSum(int[] piles, int k) {
        int n=piles.length;

        //max heap storing piles value in descending order
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        int sum=0;
        for(int i=0;i<n;i++){
            pq.offer(piles[i]);//adding all pile values
            sum+=piles[i];//maximum piles count
        }

        //applying operations k times
        for(int i=1;i<=k;i++){
            int curr=pq.poll();//removing top pile count from max heap

            int remove=curr/2;//reducing by half
            sum-=remove;//remove half from sum

            int remaining=curr-remove;//push the remianing of current tio heap

            pq.offer(remaining);
        }

        return sum;
    }
}