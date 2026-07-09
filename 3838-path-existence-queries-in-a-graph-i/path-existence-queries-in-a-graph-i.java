class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        boolean[] ans=new boolean[queries.length];
        int[] root=new int[n];
        root[0]=0;

        for(int i=1;i<n;i++){
            root[i]=((nums[i]-nums[i-1])<=maxDiff)?root[i-1]:i;
        }

        int i=0;
        for(int[] query:queries){
            ans[i++]=(root[query[0]]==root[query[1]]);
        }

        return ans;
    }
}