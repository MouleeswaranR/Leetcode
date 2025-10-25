class Solution {
    public int totalMoney(int n) {
        int totalAmount=0;
        int week=0;

        while(n>0){
            for(int day=1;day<=7;day++){
                if(n==0){
                    break;
                }
                totalAmount+=(week+day);
                n--;
            }
            week++;
        }
        return totalAmount;
    }
}