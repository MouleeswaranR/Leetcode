class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        while(left<right){
            int curr=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,curr);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}