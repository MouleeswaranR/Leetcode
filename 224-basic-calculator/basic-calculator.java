class Solution {
    public int calculate(String s) {
        int res=0,curr=0,sign=1;
        Stack<Integer> st=new Stack<>();
        for(char ch:s.toCharArray()){

            if(Character.isDigit(ch)){
                curr=curr*10+(ch-'0');
            }

            if(ch=='+'){
                res+=curr*sign;
                sign=1;
                curr=0;
            }else if(ch=='-'){
                res+=curr*sign;
                sign=-1;
                curr=0;
            }else if(ch=='('){
                st.push(res);
                st.push(sign);
                curr=0;
                sign=1;
                res=0;
            }else if(ch==')'){
                res+=curr*sign;
                curr=0;
                res*=st.pop();
                res+=st.pop();
            }
        }

        res+=sign*curr;
        return res;
    }
}