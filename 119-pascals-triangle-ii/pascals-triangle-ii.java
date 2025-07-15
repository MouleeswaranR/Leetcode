class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answer=new ArrayList<>();
        answer.add(1);
    long ans=1;
        for(int i=1;i<=rowIndex;i++){
            ans*=(rowIndex-i+1);
            ans/=i;
            answer.add((int)ans);
        }
        return answer;
    }
}