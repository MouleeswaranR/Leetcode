class NumArray {
    private int[] segmentTree;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        segmentTree=new int[4*n];
        buildSegmentTree(0,0,n-1,nums);
    }


    public void buildSegmentTree(int index,int left,int right,int[] nums){
        
        if(left==right){
            segmentTree[index]=nums[left];
            return;
        }

        int mid=left+(right-left)/2;
        buildSegmentTree(2*index+1,left,mid,nums);
        buildSegmentTree(2*index+2,mid+1,right,nums);
        segmentTree[index]=segmentTree[2*index+1]+segmentTree[2*index+2];
    }
    
    public void update(int index, int val) {
        updateSegmentTree(0,index,0,n-1,val);
    }

    public void updateSegmentTree(int index,int arrIndex,int left,int right,int val){
        
        if(left==right){
            segmentTree[index]=val;
            return;
        }

        int mid=left+(right-left)/2;
        if(arrIndex<=mid){
            updateSegmentTree(2*index+1,arrIndex,left,mid,val);
        }else{
            updateSegmentTree(2*index+2,arrIndex,mid+1,right,val);
        }
        segmentTree[index]=segmentTree[2*index+1]+segmentTree[2*index+2];
    }

    public int querySegmentTree(int start,int end,int index,int left,int right){

        if(right<start||left>end)return 0;

        if(start<=left && right<=end)
            return segmentTree[index];

        int mid=left+(right-left)/2;
        return querySegmentTree(start,end,2*index+1,left,mid)+querySegmentTree(start,end,2*index+2,mid+1,right);
    }


    
    public int sumRange(int left, int right) {
        return querySegmentTree(left,right,0,0,n-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */