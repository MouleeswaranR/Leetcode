class Solution {

    public boolean isPossible(int[][] tasks,int mid){

        for(int[] task:tasks){
            int actual=task[0],minimum=task[1];

            if(minimum>mid)return false;

            mid-=actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {
        int left=0,right=(int)1e9;

        int result=Integer.MAX_VALUE;

        Arrays.sort(tasks,(task1,task2)->{
            int diff1=task1[1]-task1[0];
            int diff2=task2[1]-task2[0];

            return diff2-diff1;
        });

        while(left<=right){
            int mid=left+(right-left)/2;

            if(isPossible(tasks,mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}