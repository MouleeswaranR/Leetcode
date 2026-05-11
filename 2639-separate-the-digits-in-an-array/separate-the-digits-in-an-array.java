class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result=new ArrayList<>();


        for(int num:nums){
            String str=String.valueOf(num);
            for(char ch:str.toCharArray()){
                result.add(ch-'0');
            }
        }

        int[] ans=new int[result.size()];

        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }

        return ans;
    }
}