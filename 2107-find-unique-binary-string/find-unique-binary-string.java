class Solution {
    private String res;
    public boolean buildNumbers(Set<String> numbers,String curr,int n){
        if(curr.length()==n){
            if(!numbers.contains(curr)){
                res=curr;
                return true;
            }
            return false;
        }
        if(buildNumbers(numbers,curr+'0',n)){
            return true;
        }
        if(buildNumbers(numbers,curr+'1',n)){
            return true;
        }
        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        Set<String> numbers=new HashSet<>(Arrays.asList(nums));
        buildNumbers(numbers,"",n);
        return res;
    }
}