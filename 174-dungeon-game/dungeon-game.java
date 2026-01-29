//Recursion+Memoization
//Time Complexity:O(row*col)
//Space Complexity: O(row*col)+Recurion Stack Space

class Solution {

    public int solve(int row,int col,int[][] dungeon,int[][] memo){
        if(row>=dungeon.length||col>=dungeon[0].length)return (int)1e9;

        if(memo[row][col]!=-1)return memo[row][col];

        if(row==dungeon.length-1 && col==dungeon[0].length-1){
            return memo[row][col]=(dungeon[row][col]>0?1:Math.abs(dungeon[row][col])+1);
        }

        int down=solve(row+1,col,dungeon,memo);
        int right=solve(row,col+1,dungeon,memo);

        int result=Math.min(down,right)-dungeon[row][col];

        return memo[row][col]=Math.max(1,result);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int rows=dungeon.length,cols=dungeon[0].length;

        int[][] memo=new int[rows][cols];
        for(int[] r:memo)Arrays.fill(r,-1);

        return solve(0,0,dungeon,memo);
    }
}

//Tabulation
//Time Complexity:O(row*col)
//Space Complexity: O(row*col)
// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int rows=dungeon.length,cols=dungeon[0].length;
//         int[][] dp=new int[rows][cols];

//         for(int row=rows-1;row>=0;row--){
//             for(int col=cols-1;col>=0;col--){
//                 if(row==rows-1 && col==cols-1){
//                     dp[row][col]=dungeon[row][col]>0?1:Math.abs(dungeon[row][col])+1;
//                 }else{
//                     int down=row+1>=rows?(int)1e9:dp[row+1][col];
//                     int right=col+1>=cols?(int)1e9:dp[row][col+1];

//                     int result=Math.min(down,right)-dungeon[row][col];
//                     dp[row][col]=Math.max(1,result);
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }