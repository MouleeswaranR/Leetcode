class Solution {
    public int countKeyChanges(String s) {
        int count=0;
        for(int i=1;i<s.length();i++){
            int st=s.charAt(i)-s.charAt(i-1);
            if(st!=32&&st!=-32&&st!=0){
                count++;
            }
        }
        return count;
    }
}