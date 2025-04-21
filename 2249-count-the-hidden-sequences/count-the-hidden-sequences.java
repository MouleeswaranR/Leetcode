class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long gap=0;
        long curr=0,max_val=0,min_val=0;
        for(int ele:differences){
            curr+=ele;
            max_val=Math.max(max_val,curr);
            min_val=Math.min(min_val,curr);
        }
        long count=(upper-lower)-(max_val-min_val)+1;
        return count >0 ?(int)count:0;
    }
}