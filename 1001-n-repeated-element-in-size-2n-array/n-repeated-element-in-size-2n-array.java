class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen=new HashSet<>();

        // for(int num:nums){
        //     if(!seen.contains(num)){
        //         seen.add(num);
        //     }else{
        //         return num;
        //     }
        // }
        // return -1;

        for(int num:nums){
            if(!seen.add(num)){
                return num;
            }
        }
        return -1;
    }
}