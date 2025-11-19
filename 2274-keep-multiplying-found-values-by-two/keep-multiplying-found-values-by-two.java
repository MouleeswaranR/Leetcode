class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numbers=new HashSet<>();
        for(int num:nums)numbers.add(num);
        while(true){
            if(numbers.contains(original)){
                original=2*original;
            }else{
                break;
            }
        } 
        return original;  
    }
}