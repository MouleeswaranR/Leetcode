class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<obstacles.length;i++){
            String key=obstacles[i][0]+"_"+obstacles[i][1];
            set.add(key);
        }

        int maxDistance=0;
        int x=0,y=0;

        int[] dir={0,1};

        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){
                dir=new int[]{-dir[1],dir[0]};
            }else if(commands[i]==-1){
                dir=new int[]{dir[1],-dir[0]};
            }else{
                for(int step=0;step<commands[i];step++){
                    int newX=x+dir[0];
                    int newY=y+dir[1];
                    
                    String newKey=newX+"_"+newY;

                    if(set.contains(newKey)){
                        break;
                    }

                    x=newX;
                    y=newY;
                }
            }

            maxDistance=Math.max(maxDistance,x*x+y*y);
        }
        return maxDistance;
    }
}