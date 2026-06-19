class Solution {
    public int lastStoneWeight(int[] stones) {
        //max heap to store max elements at top
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        //store all elements to heap
        for(int stone:stones){
            pq.offer(stone);
        }

        //if heap  size >1
        while(pq.size()>1){
            //poll top 2 stones
            int stone1=pq.poll(),stone2=pq.poll();

            //if not equal, put their absolute value in heap
            if(stone1!=stone2){
                pq.offer(Math.abs(stone1-stone2));
            }
        }

        //if heap is empty return 0, else return top value
        return pq.isEmpty()?0:pq.poll();
    }
}