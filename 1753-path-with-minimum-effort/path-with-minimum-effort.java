//Dijikstra's algo
//given source and destination
//cost- maximum absolute difference 
//requires minimum effort from all possible max abs fiff

class Solution {

    int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};

    public boolean isSafe(int newX,int newY,int m,int n){
        return (newX>=0) && (newX<m) &&(newY>=0) && (newY<n);
    }

    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length,cols=heights[0].length;

        int[][] result=new int[rows][cols];//stored less abs diff to reach (x,y)

        for(int[] row:result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[0],b[0])
        );

        //storing {difference,x,y}: difference(minimum difference from (0,0) to x,y)
        pq.offer(new int[]{0,0,0});
        result[0][0]=0;//difference between abs diff val of [0][0] and  [0][0]=0

        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int diff=top[0],x=top[1],y=top[2];//difference obtained minimum from (0,0) to (x,y)

            //as used min heap, it always stores minimum cost at top for desatination cell
            if(x==rows-1 && y==cols-1)return diff;

            //traversing through 4 directions from (x,y)
            for(int[] direction:directions){
                int newX=direction[0]+x,newY=y+direction[1];

                //check if new coordinates is not out of bounds
                if(isSafe(newX,newY,rows,cols)  ){

                    //Absolute difference(cost) between (x,y) to (newX,newY)
                    int absDiff=Math.abs(heights[x][y]-heights[newX][newY]);

                    //getting maximum difference still current cell (because that's the question asks for max abs difference)
                    int newDiff=Math.max(diff,absDiff);

                    //if stored result for (newX,newY)>newDiff, update it
                    if(result[newX][newY]>newDiff){
                        result[newX][newY]=newDiff;
                        pq.offer(new int[]{newDiff,newX,newY});
                    }
                }
            }
        }

        return result[rows-1][cols-1];
    }
}