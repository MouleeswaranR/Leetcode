class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] d1=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                d1[i][j]=grid[i][j];
                if (i>0 && j>0){
                    d1[i][j]+=d1[i-1][j-1];
                }
            }
        }

        int[][] d2=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                d2[i][j]=grid[i][j];
                if(i>0 && j+1<n){
                    d2[i][j]+=d2[i-1][j+1];
                }
            }
        }


        TreeSet<Integer> st=new TreeSet<>();

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                addSet(st,grid[r][c]);
                for(int side=1;r-side>=0 && r+side<m && c-side>=0 && c+side<n;side++){
                    int top_r=r-side,top_c=c;
                    int right_r=r,right_c=c+side;
                    int bottom_r=r+side,bottom_c=c;
                    int left_r=r,left_c=c-side;

                    int sum=0;
                    sum+=d1[right_r][right_c];
                    if(top_r-1>=0 && top_c-1>=0){
                        sum-=d1[top_r-1][top_c-1];
                    }

                    sum+=d2[bottom_r][bottom_c];
                    if(right_r-1>=0 && right_c+1<n){
                       sum-=d2[right_r-1][right_c+1]; 
                    }

                    sum += d1[bottom_r][bottom_c];
                    if (left_r-1 >= 0 && left_c-1 >= 0)
                        sum -= d1[left_r-1][left_c-1];

                    sum += d2[left_r][left_c];
                    if (top_r-1 >= 0 && top_c+1 < n)
                        sum -= d2[top_r-1][top_c+1];

                    sum-=grid[top_r][top_c];
                    sum-=grid[right_r][right_c];
                    sum-=grid[bottom_r][bottom_c];
                    sum-=grid[left_r][left_c];

                    addSet(st,sum);
                }
            }

        }
        return buildAnswer(st);
    }

    private void addSet(TreeSet<Integer> st,int value){
        st.add(value);
        if(st.size()>3){
            st.pollFirst();
        }
    }
    public int[] buildAnswer(TreeSet<Integer> st){
        int[] res=new int[st.size()];
        int idx=0;

        Iterator<Integer> it=st.descendingIterator();
        while(it.hasNext()){
            res[idx++]=it.next();
        }
        return res;
    }
}