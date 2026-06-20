class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        //counting frequency of all numbers
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //using min heap to maintain large elements at bottom
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
            (a,b)->a.getValue()-b.getValue()//sort based on frequency
        );


        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.offer(entry);

            //if heap size becomes larger than k, remove top (which are smaller frequent elements)
            if(pq.size()>k){
                pq.poll();
            }
        }


        int[] result=new int[k];

        int index=0;
        
        //poll all results 
        while(!pq.isEmpty()){
            result[index++]=pq.poll().getKey();//key is the element
        }

        return result;

    }
}