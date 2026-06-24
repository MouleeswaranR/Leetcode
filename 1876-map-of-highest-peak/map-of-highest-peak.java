//Multi-Source BFS Question
//here water cells are the sources as they are satrting to increase the height of their adjacnet node

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int rows=isWater.length,cols=isWater[0].length;

        Queue<int[]> queue=new LinkedList<>();
        int[][] height=new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                //if water cell, add it to queue and mark it height as 0
                if(isWater[row][col]==1){
                    queue.offer(new int[]{row,col});
                    height[row][col]=0;
                }else{//else mark unvisited as -1
                    height[row][col]=-1;
                }
            }
        }

        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};

        //initially process the water cells and build height from them
        while(!queue.isEmpty()){
            int size=queue.size();

        
            while(size-->0){
                int[] currentCoord=queue.poll();
                int currX=currentCoord[0],currY=currentCoord[1];

                for(int[] direction:directions){
                    int newX=currX+direction[0],newY=currY+direction[1];
                    
                    //if new cell is not visited
                    if(newX>=0 && newX<rows && newY>=0 && newY<cols && height[newX][newY]==-1){
                        queue.offer(new int[]{newX,newY});//push it into queue

                        //add height of new node's neighbour(currNode) + 1 . +1 because height diff between adjacent node should be atmost 1
                        height[newX][newY]=height[currX][currY]+1;
                    }
                }
            }
        }
        return height;
    }
}