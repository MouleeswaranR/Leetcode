class Solution {

    public void FloydWarshall(long[][] dis,char[] org,char[] tar,int[] cost){
        for(int i=0;i<org.length;i++){
            int s=org[i]-'a',t=tar[i]-'a';
            dis[s][t]=Math.min(dis[s][t],cost[i]);
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] distances=new long[26][26];

        for(int i=0;i<26;i++)Arrays.fill(distances[i],Integer.MAX_VALUE);

        FloydWarshall(distances,original,changed,cost);

        long ans=0;

        for(int i=0;i<source.length();i++){
            if(source.charAt(i)==target.charAt(i))continue;
            int s=source.charAt(i)-'a',t=target.charAt(i)-'a';

            if(distances[s][t]==Integer.MAX_VALUE){
                return -1;
            }else{
                ans+=(distances[s][t]);
            }
        }

        return ans;
    }
}