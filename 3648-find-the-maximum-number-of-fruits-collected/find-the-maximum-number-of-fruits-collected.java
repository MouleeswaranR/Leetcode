//Recurion+Memoization
//Time Complexity:O(n*n)
//Space Complexity: O(n*n) with recursion stack space

class Solution {
    public int child1Collect(int[][] fruits,int[][] memo){
        //child1 goes diagonally downward from 0,0 to n-1,n-1 because child 1 can have n-1 moves
        int count=0;
        for(int i=0;i<fruits.length;i++){
            count+=fruits[i][i];
            fruits[i][i]=0;
            memo[i][i]=0;
        }
        return count;
    }

    public int child2Collect(int[][] fruits,int row,int col,int[][] memo){
        //child2 can only use upper diagonal of grid beacuse it has to reach n-1,n-1th cell in n-1 moves
        if(row<0||row>=fruits.length||col<0||col>=fruits.length)return 0;

        //last cell fruits are picked by child1 so return 0;
        if(row==fruits.length-1 && col==fruits.length-1)return 0;

        //check if current cell is diagonal cell(child1's cell) or lower diagonal cell(child3'cell) and return 0;
        // in upper diagonal cells, row always lesser than col
        if(row==col||row>col)return 0;

        if(memo[row][col]!=-1)return memo[row][col];

        int downLeft=fruits[row][col]+child2Collect(fruits,row+1,col-1,memo);
        int down=fruits[row][col]+child2Collect(fruits,row+1,col,memo);
        int downRight=fruits[row][col]+child2Collect(fruits,row+1,col+1,memo);

        return memo[row][col]=Math.max(downLeft,Math.max(down,downRight));
    }

    public int child3Collect(int[][] fruits,int row,int col,int[][] memo){
        //child3 can only use lower diagonal of grid beacuse it has to reach n-1,n-1th cell in n-1 moves
        if(row<0||row>=fruits.length||col<0||col>=fruits.length)return 0;

        //last cell fruits are picked by child1 so return 0;
        if(row==fruits.length-1 && col==fruits.length-1)return 0;

        //check if current cell is diagonal cell(child1's cell) or upper diagonal cell(child2'cell) and return 0;
        // in lower diagonal cells, row always greater than col
        if(row==col||row<col)return 0;

        if(memo[row][col]!=-1)return memo[row][col];

        int downRight=fruits[row][col]+child3Collect(fruits,row+1,col+1,memo);
        int right=fruits[row][col]+child3Collect(fruits,row,col+1,memo);
        int upRight=fruits[row][col]+child3Collect(fruits,row-1,col+1,memo);

        return memo[row][col]=Math.max(right,Math.max(upRight,downRight));
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n=fruits.length;
        int[][] memo=new int[n][n];

        for(int[] r:memo)Arrays.fill(r,-1);

        int child1Score=child1Collect(fruits,memo);
        int child2Score=child2Collect(fruits,0,n-1,memo);
        int child3Score=child3Collect(fruits,n-1,0,memo);

        return child1Score+child2Score+child3Score;
    }
}