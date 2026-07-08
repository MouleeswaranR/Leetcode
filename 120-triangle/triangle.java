class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        memo=new Integer[n][n];
        return solve(0,0,triangle,triangle.size());
    }


    public int solve(int row,int col,List<List<Integer>> triangle,int n){
        if(row==n-1){
            return triangle.get(row).get(col);
        }
        
        if(memo[row][col]!=null)return memo[row][col];
        int down=solve(row+1,col,triangle,n);
        int diagonal=solve(row+1,col+1,triangle,n);

        return memo[row][col]=triangle.get(row).get(col)+Math.min(down,diagonal);
    }
}