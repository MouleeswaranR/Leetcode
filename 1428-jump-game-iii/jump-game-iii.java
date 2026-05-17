class Solution {
    public boolean dfs(int[] arr,int n,int start){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);


        while(!queue.isEmpty()){
            int curr=queue.poll();

            if(arr[curr]==0)return true;

            if(arr[curr]<0)continue;

            int left=curr+arr[curr];
            int right=curr-arr[curr];

            if(left>=0 && left<n){
                queue.add(left);
            }

            if(right>=0 && right<n){
                queue.add(right);
            }

            arr[curr]=-arr[curr];
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        return dfs(arr,n,start);
    }
}