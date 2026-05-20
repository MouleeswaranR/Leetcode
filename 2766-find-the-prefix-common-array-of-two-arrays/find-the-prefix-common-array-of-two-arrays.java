class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,count=0;
        int[] result=new int[n];
        boolean[] seen=new boolean[n];


        for(int i=0;i<n;i++){
            if(seen[A[i]-1])count++;
            else seen[A[i]-1]=true;

            if(seen[B[i]-1])count++;
            else seen[B[i]-1]=true;


            result[i]=count;
        }

        return result;
    }
}