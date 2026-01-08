class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int[] current=new int[n+1],prev=new int[n+1];
        Arrays.fill(current,Integer.MIN_VALUE);
        Arrays.fill(prev,Integer.MIN_VALUE);

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int currPro=nums1[i-1]*nums2[j-1];
                current[j]=Math.max(Math.max(Math.max(currPro,prev[j]),current[j-1]),currPro+Math.max(0,prev[j-1]));
            }
            int[] temp=current;
            current=prev;
            prev=temp;
        }
        return prev[n];
    }
}