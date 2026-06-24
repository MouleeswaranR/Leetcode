
//Multi-Source BFS=>here all the rotten oranges are sources,need minimum time to rot all fresh oranges
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;

        Queue<int[]> queue=new LinkedList<>();
        int freshCount=0;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                //getting initial rotten oranges
                if(grid[row][col]==2){
                    queue.offer(new int[]{row,col});
                }else if(grid[row][col]==1){
                    freshCount++;//count initial fresh oranges
                }
            }
        }

        //if there are no fresh ornages to return, return 0
        if(freshCount==0)return 0;

        int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};
        int time=0;

        while(!queue.isEmpty()){
            int size=queue.size();

            while(size-->0){
                int[] currentCoordinates=queue.poll();

                int currX=currentCoordinates[0],currY=currentCoordinates[1];

                for(int[] direction:directions){
                    int newX=currX+direction[0],newY=currY+direction[1];

                    //check if new coordinate orange is fresh(equal to 1)
                    if(newX>=0 && newX<rows && newY>=0 && newY<cols && grid[newX][newY]==1){
                        grid[newX][newY]=2;//rot current orange
                        queue.offer(new int[]{newX,newY});//push it into queue
                        freshCount--;//reduce one freah orange as it is rotten
                    }
                }   
               
            }
             time++;//increase the time for each level
        }

        return freshCount==0?time-1:-1;//if there are still fresh oranges,return -1
    }
}