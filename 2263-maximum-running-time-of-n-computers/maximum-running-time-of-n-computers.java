class Solution {
    public boolean possible(int[] batteries,long mid,int n){
        long target=mid*n;
        for(int battery:batteries){
            target-=Math.min((long)battery,mid);
            if(target<=0)return true;
        }
        return target<=0;
    }
    public long maxRunTime(int n, int[] batteries) {
        long l=Long.MAX_VALUE;

        long sum=0;
        for(int battery:batteries){
            l=Math.min(l,battery);
            sum+=battery;
        }
        long r=sum/n;

        long result=0;

        while(l<=r){
            long mid=l+(r-l)/2;

            if(possible(batteries,mid,n)){
                result=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return result;
    }
}