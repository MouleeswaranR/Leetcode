class Solution {
    List<String> happy=new ArrayList<>();
    public String getHappyString(int n, int k) {
        char[] chars={'a','b','c'};
        generateHappyString("",chars,n);
        return k>happy.size()?"":happy.get(k-1);
    }
    public void generateHappyString(String path,char[] chars,int n){
        if(path.length()==n){
            happy.add(path);
            return;
        }
        for(char ch:chars){
            if(path.isEmpty()||path.charAt(path.length()-1)!=ch){
                generateHappyString(path+ch,chars,n);
            }
        }
    }
}