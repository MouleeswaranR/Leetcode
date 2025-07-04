class Solution {
    public char kthCharacter(long k, int[] operations) {
        int countOps=0;
        long val=k;
        while(val>1){
            int jumps=(int)Math.ceil((Math.log(val))/Math.log(2));
            val-=(long)Math.pow(2,jumps-1);
            countOps+=operations[jumps-1];
        }
        return (char)('a'+(countOps%26));
    }
}