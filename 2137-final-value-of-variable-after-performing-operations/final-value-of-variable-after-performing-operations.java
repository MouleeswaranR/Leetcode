class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X=0;
        for(String operation:operations){
            if(operation.contains("+")){
                X+=1;
            }else{
                X-=1;
            }
        }
        return X;
    }
}