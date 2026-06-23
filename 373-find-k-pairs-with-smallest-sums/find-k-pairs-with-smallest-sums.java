class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
       //max heap(want k smallest sums so always pops largest one at top) stores {sum,index1(from nums1),index2(from num2)}
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(b[0],a[0])
        );

        int m=nums1.length,n=nums2.length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=nums1[i]+nums2[j];

                //if heap size less than k,push  into it 
                if(pq.size()<k){
                    pq.offer(new int[]{sum,i,j});
                }else if(pq.peek()[0]>sum){//if sum of top of heap is greater , we don't need it we need ones with smallest sum,poll top one, push current one
                    pq.poll();
                    pq.offer(new int[]{sum,i,j});
                }else{//here as the arrays are sorted, if one element sum cant be pushed into heap, sum from fixed i and next j's can't be pushed because they will be larger one, so skip the inner j loop
                    break;
                }
            }
        }

        List<List<Integer>> result=new ArrayList<>();

        while(pq.size()>0){
            int[] top=pq.poll();

            result.add(
                Arrays.asList(
                    nums1[top[1]],
                    nums2[top[2]]
                )
            );
        }

        return result;

    }
}