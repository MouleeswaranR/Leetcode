class Solution {
    public boolean check(int mid,int n,long k,Map<Integer,List<int[]>> adjList){
        long[] result=new long[n];
        Arrays.fill(result,Long.MAX_VALUE);

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        result[0]=0;
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long currDist=curr[0];
            int currNode=(int)curr[1];

            if(currDist>k)return false;

            if(currNode==n-1)return true;

            if(currDist>result[currNode])continue;

            for(int[] neighbor:adjList.getOrDefault(currNode,new ArrayList<>())){
                int adjNode=neighbor[0],weight=neighbor[1];

                if(weight<mid)continue;

                if(currDist+weight<result[adjNode]){
                    result[adjNode]=currDist+weight;
                    pq.offer(new long[]{currDist+weight,adjNode});
                }
            }
        }
        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;

        Map<Integer,List<int[]>> adjList=new HashMap<>();

        int left=Integer.MAX_VALUE,right=0;

        for(int[] edge:edges){
            int u=edge[0],v=edge[1],w=edge[2];

            if(!online[u]||!online[v])continue;
            adjList.computeIfAbsent(u,x->new ArrayList<>()).add(new int[]{v,w});
            left=Math.min(left,w);
            right=Math.max(right,w);
        }

        int result=-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(check(mid,n,k,adjList)){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return result;
    }
}