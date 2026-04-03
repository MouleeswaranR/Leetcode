class Solution {
    int[][] memo;


    public int countWalls(int[] walls,int left,int right){
        int leftRange=lowerBound(walls,left);
        int rightRange=upperBound(walls,right);
        return rightRange-leftRange;
    }

    public int lowerBound(int[] walls,int target){
        int left=0,right=walls.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(walls[mid]>=target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public int upperBound(int[] walls,int target){
        int left=0,right=walls.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(walls[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public int solve(int[] walls,int[][] roboDist,int[][] range,int i,int prevDir){
        if(i==roboDist.length)return 0;

        if(memo[i][prevDir]!=-1)return memo[i][prevDir];
        int leftStart=range[i][0];

        if(prevDir==1 && i>0){
            leftStart=Math.max(leftStart,range[i-1][1]+1);
        }

        int leftTake=countWalls(walls,leftStart,roboDist[i][0])+solve(walls,roboDist,range,i+1,0);

        int rightTake=countWalls(walls,roboDist[i][0],range[i][1])+solve(walls,roboDist,range,i+1,1);

        return memo[i][prevDir]=Math.max(leftTake,rightTake);

    }


    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n=robots.length;

        int[][] roboDist=new int[n][2]; //robot_pos,distance

        for(int i=0;i<n;i++){
            roboDist[i][0]=robots[i];
            roboDist[i][1]=distance[i];
        }

        Arrays.sort(roboDist,(a,b)->Integer.compare(a[0],b[0]));

        Arrays.sort(walls);


        int[][] range=new int[n][2];

        for(int i=0;i<n;i++){
            int pos=roboDist[i][0],dist=roboDist[i][1];

            int leftLimit=(i==0)?1:roboDist[i-1][0]+1;
            int rightLimit=(i==n-1)?(int)1e9:roboDist[i+1][0]-1;

            int left=Math.max(pos-dist,leftLimit);
            int right=Math.min(pos+dist,rightLimit);

            range[i][0]=left;
            range[i][1]=right;
        }

        memo=new int[n][2];

        for(int[] arr: memo)Arrays.fill(arr,-1);

        return solve(walls,roboDist,range,0,0);

    }
}