class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        boolean[] contains=new boolean[101];

        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
            contains[num]=true;
        }

        for(int i=min;i<=max;i++){
            if(!contains[i])ans.add(i);
        }

        return ans;
    }
}