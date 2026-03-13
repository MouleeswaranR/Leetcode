class Solution {
    public boolean check(int[] workerTimes,int mountainHeight, long midH ){
        long height=0;

        for(int time:workerTimes){
            height+=(long)(Math.sqrt(2.0*midH/time+0.25)-0.5);

            if(height>=mountainHeight)return true;
        }

        return height>=mountainHeight;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxTime=0;

        for(int time:workerTimes)maxTime=Math.max(maxTime,time);

        long left=1;
        long right=(long)maxTime*mountainHeight*(mountainHeight+1)/2;


        long result=0;
        while(left<=right){
            long mid=left+(right-left)/2;

            if(check(workerTimes,mountainHeight,mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}