class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;

        int[] required=new int[n];

        for(int i=0;i<n;i++){
            int current_rocks=rocks[i];
            int capacity_rocks=capacity[i];

            required[i]=capacity_rocks-current_rocks;
        }

        Arrays.sort(required);

        int count=0;

        for(int i=0;i<n;i++){
            if(required[i]==0){
                count++;
            }else{
                if(additionalRocks>=required[i]){
                    additionalRocks-=required[i];
                    count++;
                }else{
                    break;
                }
            }
        }

        return count;
    }
}