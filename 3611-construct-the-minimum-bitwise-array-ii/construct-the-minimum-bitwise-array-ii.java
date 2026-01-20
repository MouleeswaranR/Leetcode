class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int num=nums.get(i);
            boolean found=false;

            if(num==2){
                result[i]=-1;
                continue;
            }
            for(int j=1;j<32;j++){
                if((num & (1<<j))!=0){
                    continue;
                }

                int ans=num^(1<<(j-1));
                result[i]=ans;
                found=true;
                break;
            }
            if(!found){
                result[i]=-1;
            }
        }
        return result;
    }
}