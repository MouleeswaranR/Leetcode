class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length,m=potions.length;
        int[] pairs=new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int spell=spells[i];
            int left=0,right=m-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                long prod=(long)spell*potions[mid];
                if(prod>=success){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            pairs[i]=m-left;
        }
        return pairs;
    }
}