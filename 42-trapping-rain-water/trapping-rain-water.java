class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int start=0,end=n-1;

        int leftMax=Integer.MIN_VALUE,rightMax=Integer.MIN_VALUE;
        int total=0;
        while(start<end){
            leftMax=Math.max(leftMax,height[start]);
            rightMax=Math.max(rightMax,height[end]);

            if(leftMax<rightMax){
                total+=leftMax-height[start];
                start++;
            }else{
                total+=rightMax-height[end];
                end--;
            }
        }

        return total;
    }
}