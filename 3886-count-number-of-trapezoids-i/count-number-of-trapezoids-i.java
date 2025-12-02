class Solution {
    private static int MOD=(int)1e9+7;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int[] point:points){
            int y=point[1];
            mpp.put(y,mpp.getOrDefault(y,0)+1);
        }

        long result=0;
        long prevhorizLines=0;

        for(int count:mpp.values()){
            long horizLines=(long)count*(count-1)/2;
            result=(result+horizLines*prevhorizLines)%MOD;
            prevhorizLines+=horizLines;
        }
        return (int)(result%MOD);
    }
}