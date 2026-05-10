class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;

        int layers=Math.min(m/2,n/2);


        for(int layer=0;layer<layers;layer++){

            List<Integer> nums=new ArrayList<Integer>();

            int left=layer;
            int right=n-layer-1;
            int top=layer;
            int bottom=m-layer-1;

            for(int j=left;j<=right;j++){
                nums.add(grid[top][j]);
            }

            for(int i=top+1;i<=bottom-1;i++){
                nums.add(grid[i][right]);
            }

            for(int j=right;j>=left;j--){
                nums.add(grid[bottom][j]);
            }

            for(int i=bottom-1;i>=top+1;i--){
                nums.add(grid[i][left]);
            }

            int len=nums.size();

            int normalizedK=k%len;

            Collections.rotate(nums,-normalizedK);

            int idx=0;

            for(int j=left;j<=right;j++){
                grid[top][j]=nums.get(idx++);
            }

            for(int i=top+1;i<=bottom-1;i++){
                grid[i][right]=nums.get(idx++);
            }

            for(int j=right; j>=left;j--){
                grid[bottom][j]=nums.get(idx++);
            }


            for(int i=bottom-1;i>=top+1;i--){
                grid[i][left]=nums.get(idx++);
            }
        }

        return grid;
    }
}