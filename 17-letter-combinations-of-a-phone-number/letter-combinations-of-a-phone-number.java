class Solution {
    List<String> res=null;
    String[] digitToLetters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
       res=new ArrayList<>();
       if(digits.length()==0)return res;
       fun(0,digits,new StringBuilder(""));
       return res;

    }
    void fun(int len,String dig,StringBuilder temp){
        if(len==dig.length()){
            res.add(temp.toString());
            return;
        }
        char ch=dig.charAt(len);
        String str=digitToLetters[ch-'0'];
        for(char c:str.toCharArray()){
            temp.append(c);
            fun(len+1,dig,temp);
            temp.deleteCharAt(temp.length()-1);
        }
       
    }
}