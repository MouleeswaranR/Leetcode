class Solution {
    public boolean isSorted(List<Integer> ls){
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i)>ls.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public int minSumPair(List<Integer> ls){
        int minSum=Integer.MAX_VALUE;
        int index=-1;

        for(int i=0;i<ls.size()-1;i++){
            int sum=ls.get(i)+ls.get(i+1);
            if(sum<minSum){
                minSum=sum;
                index=i;
            }
        }
        return index;
    }
    public int minimumPairRemoval(int[] nums) {
        List<Integer> ls=new ArrayList<>();
        for(int num:nums)ls.add(num);

        int operations=0;

        while(!isSorted(ls)){
            int index=minSumPair(ls);

            int merged=ls.get(index)+ls.get(index+1);
            ls.set(index,merged);
            ls.remove(index+1);

            operations++;
        }
        return operations;
    }
}