class Solution {
    private int MOD=1000000007;
    public int numberOfWays(String corridor) {
        ArrayList<Integer> pos=new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S')pos.add(i);
        }

        if(pos.size()%2>0||pos.size()==0)return 0;

        long result=1;
        int prevEnd=pos.get(1);

        for(int i=2;i<pos.size();i+=2){
            int len=pos.get(i)-prevEnd;
            result=(result*len)%MOD;
            prevEnd=pos.get(i+1);
        }
        return (int)result;
    }
}