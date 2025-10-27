class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0,total=0;
        for(String row:bank){
            int curr=0;
            for(char c:row.toCharArray()){
                if(c=='1')curr++;
            }
            if(curr>0){
                total+=(prev*curr);
                prev=curr;
            }
        }
        return total;
    }
}