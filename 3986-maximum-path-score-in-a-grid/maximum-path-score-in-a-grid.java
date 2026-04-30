class Solution {
    public int maxPathScore(int[][] grid, int k) {

        int dp[][][] = new int[grid.length][grid[0].length][k+1];
        for(int i = 0 ; i<dp.length ; i++){
            for(int j = 0 ; j<dp[0].length ; j++){
                for(int x = 0 ; x<dp[0][0] . length ; x++){
                    dp[i][j][x] = -1 ; 
                }
            }
        }

        int ans = solve(0 , 0 , 0  , grid , k , dp);

        if(ans == Integer.MIN_VALUE) return -1;

        return ans ; 
        
    }

    public int solve(int i , int j ,  int cost , int grid[][] , int k , int dp[][][]){

        if(grid[i][j] == 1 || grid[i][j] == 2){
            cost++;
        }
        
        if(cost > k) return Integer.MIN_VALUE ;

        if(i== grid.length-1 && j == grid[0].length-1){

            return dp[i][j][cost] =  grid[i][j] ; 
        }

        if(dp[i][j][cost] != -1) return dp[i][j][cost];

        int right = Integer.MIN_VALUE ;
        if(j+1 < grid[0].length){
            right = solve(i,j+1 , cost , grid , k , dp);
        }

        int down = Integer.MIN_VALUE ;
        if(i+1 < grid.length ){
            down = solve(i+1 , j , cost , grid , k , dp);
        }


        int best = Math.max(right, down);
        return dp[i][j][cost] = (best == Integer.MIN_VALUE) ? Integer.MIN_VALUE : grid[i][j] + best;
    }
}