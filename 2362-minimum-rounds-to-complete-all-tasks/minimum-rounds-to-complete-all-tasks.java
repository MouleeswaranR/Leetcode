class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> counts=new HashMap<>();

        for(int task:tasks){
            counts.put(task,counts.getOrDefault(task,0)+1);
        }

        int rounds=0;

        //here we have possibilty of picking either 2 or 3. give importance to 3 because needed to get minimum rounds

        //here every number can be represented as 3k,3k+1,3k+2
        //for number giving mod result of 1 or 2 with 3 . for eg: 8 => 2 times 3 tasks and 1 time 2 task=>2+1=>3 rounds. 8/3=>2+1=3
        for(int value:counts.values()){
            if(value==1)return -1;
            if(value%3==0){
                rounds+=(value/3);
            }else{
                rounds+=(value/3)+1;
            }
        }
        return rounds;
    }
}