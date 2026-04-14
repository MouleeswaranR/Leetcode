class Solution {
    public long solve(int roboInd,int factInd,List<Integer> robot,List<Integer> positions,long[][] memo){
        if(roboInd>=robot.size())return 0;

        if(factInd>=positions.size())return (long)1e12;

        if(memo[roboInd][factInd]!=-1)return memo[roboInd][factInd];
        long takeCurrFactory=Math.abs(robot.get(roboInd)-positions.get(factInd))+solve(roboInd+1,factInd+1,robot,positions,memo);
        long skip=solve(roboInd,factInd+1,robot,positions,memo);

        return memo[roboInd][factInd]=Math.min(takeCurrFactory,skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);

        Arrays.sort(factory,Comparator.comparingInt(a->a[0]));

        List<Integer> positions=new ArrayList<>();

        int m=robot.size();

        for(int i=0;i<factory.length;i++){
            int pos=factory[i][0],limit=factory[i][1];

            for(int j=0;j<limit;j++){
                positions.add(pos);
            }
        }

        int n=positions.size();

        long[][] memo=new long[m+1][n+1];

        for(long[] row:memo){
            Arrays.fill(row,-1);
        }

        return solve(0,0,robot,positions,memo);
    }
}