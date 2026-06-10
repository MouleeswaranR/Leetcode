class SegmentTree{
    int[] segmentTree;
    boolean isMinTree;

    SegmentTree(int[] nums,boolean flag){
        int n=nums.length;
        segmentTree=new int[4*n];
        this.isMinTree=flag;
        buildSegmentTree(0,0,n-1,nums);
    }

    void buildSegmentTree(int pos, int left, int right,int[] nums){
        if(left==right){
            segmentTree[pos]=nums[left];
            return;
        }

        int mid=left+(right-left)/2;

        buildSegmentTree(2*pos+1,left,mid,nums);
        buildSegmentTree(2*pos+2,mid+1,right,nums);

        if(isMinTree){
            segmentTree[pos]=Math.min(segmentTree[2*pos+1],segmentTree[2*pos+2]);
        }else{
             segmentTree[pos]=Math.max(segmentTree[2*pos+1],segmentTree[2*pos+2]);
        }
    }

    int querySegmentTree(int start,int end,int pos,int left,int right){

        if(left>end||right<start){
            return isMinTree?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

        if(start<=left && right<=end){
            return segmentTree[pos];
        }


        int mid=left+(right-left)/2;

        int a=querySegmentTree(start,end,2*pos+1,left,mid);
        int b=querySegmentTree(start,end,2*pos+2,mid+1,right);

        if(isMinTree){
            return Math.min(a,b);
        }

        return Math.max(a,b);
    }

    int query(int left,int right,int n){
        return querySegmentTree(left,right,0,0,n-1);
    }
}

class Solution {

    long getValue(int left,int right,SegmentTree minTree,SegmentTree maxTree,int n){
        int minVal=minTree.query(left,right,n);
        int maxVal=maxTree.query(left,right,n);
        return (long)(maxVal-minVal);
    }

    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;

        SegmentTree minTree=new SegmentTree(nums,true);
        SegmentTree maxTree=new SegmentTree(nums,false);

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(b[0],a[0]));

        for(int l=0;l<n;l++){
            long value=getValue(l,n-1,minTree,maxTree,n);
            pq.offer(new long[]{value,l,n-1});
        }

        long result=0;

        while(k-->0){
            long[] top=pq.poll();
            long value=top[0];
            int left=(int)top[1],right=(int)top[2];

            result+=value;

           if(right > left){
            long nextBestValue =
                getValue(left,right-1,minTree,maxTree,n);

            pq.offer(new long[]{
                nextBestValue,
                left,
                right-1
            });
        }
        }

        return result;
    }
}