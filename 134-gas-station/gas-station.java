class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gain=0,curr_gain=0;
        int start_pos=0;


        for(int i=0;i<gas.length;i++){
            int gain=gas[i]-cost[i];
            total_gain+=gain;
            curr_gain+=gain;

            if(curr_gain<0){
                curr_gain=0;
                start_pos=i+1;
            }
        }
        if(total_gain>=0){
            return start_pos;
        }
        return -1;
        
    }
}