class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int num:nums)mpp.put(num,mpp.getOrDefault(num,0)+1);
        int[] ans=new int[2];
        int index=0;
        for(Map.Entry<Integer,Integer> entry:mpp.entrySet()){
            int key=entry.getKey(),val=entry.getValue();
            if(val>1){
                ans[index]=key;
                index++;
            }
        }
        return ans;
    }
}