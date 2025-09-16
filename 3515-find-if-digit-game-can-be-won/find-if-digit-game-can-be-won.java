class Solution {
    public boolean canAliceWin(int[] nums) {
        int alice=0,bob=0;
        for(int num:nums){
            if(num<10){
                alice+=num;
            }else{
                bob+=num;
            }
        }
        return alice!=bob;
    }
}