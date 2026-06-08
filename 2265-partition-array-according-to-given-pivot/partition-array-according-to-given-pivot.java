class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] result=new int[n];

        int i=0,j=nums.length-1;
        int i_=0,j_=nums.length-1;


        while(i<n && j>=0){
            if(nums[i]<pivot){
                result[i_]=nums[i];
                i_++;
            }

            if(nums[j]>pivot){
                result[j_]=nums[j];
                j_--;
            }

            i++;
            j--;
        }

        while(i_<=j_){
            result[i_]=pivot;
            i_++;
        }

        return result;
    }
}