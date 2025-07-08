class Solution {
    public String addStrings(String num1, String num2) {
        int n1=num1.length()-1,n2=num2.length()-1,carry=0;
        StringBuilder str=new StringBuilder();
        while(n1>=0||n2>=0||carry!=0){
            int a=n1>=0?num1.charAt(n1)-'0':0;
            int b=n2>=0?num2.charAt(n2)-'0':0;
            int result=a+b+carry;
            carry=result/10;
            str.append(result%10);
            n1--;
            n2--;
        }
        return str.reverse().toString();
    }
}