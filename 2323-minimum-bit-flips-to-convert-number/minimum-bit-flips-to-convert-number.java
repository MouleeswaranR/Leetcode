class Solution {
    public int minBitFlips(int start, int goal) {
        int num=start^goal;
        int count=0;
        while(num!=0){
            if((num&1)==1)count++;
            num=num>>1;
        }
        if(num==1)count++;
        return count;
    }
}