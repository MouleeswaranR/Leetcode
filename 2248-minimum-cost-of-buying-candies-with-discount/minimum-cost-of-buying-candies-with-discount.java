class Solution {
    public int minimumCost(int[] cost) {
       int n=cost.length;
       Arrays.sort(cost);

       for(int l=0,r=n-1;l<r;l++,r--){
        int temp=cost[l];
        cost[l]=cost[r];
        cost[r]=temp;
       } 

       int totalCost=0;
       for(int i=0;i<n;i++){
        if(i%3!=2){
            totalCost+=cost[i];
        }
       }
       return totalCost;
    }
}