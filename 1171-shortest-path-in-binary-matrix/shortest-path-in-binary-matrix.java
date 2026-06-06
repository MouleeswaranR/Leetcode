//used Dijikstra's Algo
// i) given source(0,0), destination (m-1)(n-1)
// ii) needed shortest ditance


///------------can also use normal queue no issue because as all cells moves by distance cost of 1

// int level=0;
// Queue<int[]> queue=new LinkedList<>();
//grid[0][0]=1;//mrking (0,0) as visited
// while(!queue.isEmpty()){
//     int size=queue.size();

//     while(size-->0){
//             int[] top=queue.poll();
//             int distance=top[0],x=top[1],y=top[2];

//             if(x==m-1 && y==n-1)return level+1;//if destination reached

//             //trying to move in all 8 directions from current popped cell
//             for(int[] direction:directions){
//                 int newX=x+direction[0],newY=y+direction[1];//trying to reach from (x,y) to (newX,newY)
//                 int dist=1;//cost to reach (newX,newY) coordinated from its any nearby cell

//                 //check if new x,y direction is out of bounds and that cell is still not visited 
//                 if(isSafe(newX,newY,m,n) && grid[newX][newY]==0 ){
//                     grid[newX][newY]=1;//update new cell as visited by marking it as one
//                     queue.push(new int[]{newX,newY});//push it to queue
//                 }
//         }
//     }
//     level++;//after completing one level

    
// }
//    return -1;//if unreachable

//-------------can also use normal queue in dijisktra's for same reason as above

//just change priority queue to queue in min heap solution



class Solution {

    //all 8 directions to move in a cell
    int[][] directions={
        {-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}
    };

    public boolean isSafe(int newX,int newY,int m, int n){
        return (newX>=0) && (newX<m) && (newY>=0) && (newY<n);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;

        //edge case if there is no row and col or first cell is already visited
        if(rows==0||cols==0||grid[0][0]!=0){
            return -1;
        }

        int[][] result=new int[rows][cols];

        for(int[] row: result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        //stores [distance from (0,0) to (x,y),x,y] in min heap
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[0],b[0])
        );

        pq.offer(new int[]{0,0,0});//initial cell (0,0) takes 0 cost to reach (0,0)
        grid[0][0]=1; //mark (0,0) as visited initially
        result[0][0]=0; // cost of (0,0) to reach (0,0) = 0

        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int distance=top[0],x=top[1],y=top[2];

            //trying to move in all 8 directions from current popped cell
            for(int[] direction:directions){
                int newX=x+direction[0],newY=y+direction[1];//trying to reach from (x,y) to (newX,newY)
                int dist=1;//cost to reach (newX,newY) coordinated from its any nearby cell

                //check if new x,y direction is out of bounds and that cell is still not visited
                //also check if shortest distance for (newX,newY) from (0,0) is less than current cell distance+1,
                //if satisified,update it 
                if(isSafe(newX,newY,rows,cols) && grid[newX][newY]==0 && distance+dist<result[newX][newY]){
                    result[newX][newY]=distance+dist;//update new shortest cost
                    grid[newX][newY]=1;//update new cell as visited by marking it as one
                    pq.offer(new int[]{distance+dist,newX,newY});//push it to queue
                }
            }
        }

        return result[rows-1][cols-1]==Integer.MAX_VALUE?-1:result[rows-1][cols-1]+1;//as result stores shortest cost but need count of cells so +1
    }
}