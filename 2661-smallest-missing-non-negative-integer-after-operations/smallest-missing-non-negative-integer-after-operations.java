class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count=new int[value];
        for(int num:nums){
            count[(num%value+value)%value]++;
        }
        int stop=0;
        for(int i=0;i<value;i++){
            if(count[i]<count[stop]){
                stop=i;
            }
        }
        return value*count[stop]+stop;
    }
}