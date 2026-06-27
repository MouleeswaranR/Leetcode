class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Long> freq=new HashMap<>();

        for(int num:nums){
            freq.put((long)num,freq.getOrDefault((long)num,0L)+1);
        }

        long result=0;

        for(Map.Entry<Long,Long> entry:freq.entrySet()){
            long curr=entry.getKey();

            if(curr==1){
                result=Math.max(result,freq.get(1L)%2==0?freq.get(1L)-1:freq.get(1L));
                continue;
            }

            long currLen=0;
            while(freq.containsKey(curr) && freq.get(curr)>=2){
                currLen+=2;
                curr*=curr;
            }

            if(freq.containsKey(curr) && freq.get(curr)==1){
                currLen++;
            }else{
                currLen--;
            }
            result=Math.max(result,currLen);
        }

        return (int)result;
    }
}