class Solution {
    public int minOperations(int[][] grid, int x) {
        int m=grid.length,n=grid[0].length;

        List<Integer> vec=new ArrayList<>();


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vec.add(grid[i][j]);
            }
        }

        Collections.sort(vec);
        int len=vec.size();
        int target=vec.get(len/2);


        int result=0;
        for(int num:vec){
            if(target%x != num%x){
                return -1;
            }
            result+=Math.abs(target-num)/x;
        }
        return result;
    }
}