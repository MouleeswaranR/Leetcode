class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st= new Stack<>();
        int res=0;
        for(int i=0;i<op.length;i++){
             
            if(!op[i].equals("D") && !op[i].equals("C") &&!op[i].equals("+")){
                st.push(Integer.parseInt(op[i]));
            }
            else if(op[i].equals("D")){
                
                st.push(2*st.peek());
            }
            else if(op[i].equals("C")){
                st.pop();
            }
            else{
                int n1=st.pop();
                int n2=st.peek();
                st.push(n1);
                st.push(n1+n2);
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();

        }
        return res;
        
    }
}