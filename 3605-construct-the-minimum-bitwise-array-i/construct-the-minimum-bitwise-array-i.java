class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            boolean found=false;
            for(int x=0;x<nums.get(i);x++){
                if((x|(x+1))==nums.get(i)){
                    result[i]=x;
                    found=true;
                    break;
                }
            }
            if(!found){
                result[i]=-1;
            }
        }
        return result;
    }
}