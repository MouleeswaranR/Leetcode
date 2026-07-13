class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();

        StringBuilder ans=new StringBuilder();

    for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch=='('){
            if(st.size()>0){
                ans.append(ch);
            }
            st.push(ch);
        }else{
            st.pop();
            if(st.size()>0)ans.append(ch);
        }
    }
    return ans.toString();
    }
}