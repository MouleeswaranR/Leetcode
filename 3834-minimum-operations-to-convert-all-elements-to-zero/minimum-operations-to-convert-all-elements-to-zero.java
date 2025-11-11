class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int ops=0;

        for(int num:nums){
            while(!st.isEmpty() && st.peek()>num){
                st.pop();
            }
            if(num==0)continue;
            if(st.isEmpty()||st.peek()<num){
                st.push(num);
                ops++;
            }
        }
        return ops;
    }
}