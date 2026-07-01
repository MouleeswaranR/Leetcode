class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

     boolean checkDistance(int[][] distNearestThief, int sf,int n) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        que.add(new int[]{0, 0});
        visited[0][0] = true;

        if(distNearestThief[0][0] < sf)
            return false;

        while(!que.isEmpty()) {
            int[] curr = que.poll();
            int curr_i = curr[0];
            int curr_j = curr[1];

            if(curr_i == n-1 && curr_j == n-1) {
                return true;
            }

            for(int[] dir : directions) {
                int new_i = curr_i + dir[0];
                int new_j = curr_j + dir[1];

                if(new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                    if(distNearestThief[new_i][new_j] < sf) {
                        continue; 
                    }
                    que.add(new int[]{new_i, new_j});
                    visited[new_i][new_j] = true;
                }
            }
        }

        return false;
    }


    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows=grid.size(),cols=grid.get(0).size();

        Queue<int[]> queue=new LinkedList<>();
        boolean[][] visited=new boolean[rows][cols];
        int[][] distNearestThief=new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid.get(row).get(col)==1){
                    queue.offer(new int[]{row,col});
                    visited[row][col]=true;
                }
            }
        }

        int level=0;
        
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] curr=queue.poll();
                int currX=curr[0],currY=curr[1];

                distNearestThief[currX][currY]=level;

                for(int[] direction:directions){
                    int newX=direction[0]+currX,newY=direction[1]+currY;

                   if (newX < 0 || newX >= rows ||
                        newY < 0 || newY >= cols ||
                        visited[newX][newY]) {
                        continue;
                    }

                    queue.offer(new int[]{newX,newY});
                    visited[newX][newY]=true;
                }
                
            }
            level++;
        }

        int left=0,right=400,result=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(checkDistance(distNearestThief,mid,rows)){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }
}