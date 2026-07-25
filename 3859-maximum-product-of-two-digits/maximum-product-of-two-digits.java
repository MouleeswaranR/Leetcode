class Solution {
    public int maxProduct(int n) {
        int ans=1;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while(n>0){
            int temp=n%10;
            pq.offer(temp);
            if(pq.size()>2)pq.poll();
            n/=10;
        }
        return pq.poll()*pq.poll();
    }
}