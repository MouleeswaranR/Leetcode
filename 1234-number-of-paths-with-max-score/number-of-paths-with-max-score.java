class Solution {
    int n;
    int[][] tScores,tPaths;
    int MOD = 1_000_000_007;

    public boolean isValid(int i,int j,List<String> board){
        if(i>=0 && i<n && j>=0 && j<n && board.get(i).charAt(j)!='X'){
            return true;
        }
        return false;
    }
    
    public int getIntFromChar(char ch){
        return ch!='S'?ch-'0':0;
    }

    public int[] solve(int i,int j,List<String> board){
        char currChar=board.get(i).charAt(j);
        if(currChar=='E'){
            return new int[]{0,1};
        }

        if(currChar=='X'){
            return new int[]{0,0};
        }

        if(tScores[i][j]!=-1){
            return new int[]{tScores[i][j],tPaths[i][j]};
        }

        int upScore=0,upPaths=0;
        int leftScore=0,leftPaths=0;
        int diagScore=0,diagPaths=0;

        char ch=currChar;

        if(isValid(i-1,j,board)){
            int[] result=solve(i-1,j,board);
            upScore=result[0];upPaths=result[1];
            if(upPaths>0)upScore+=getIntFromChar(ch);
        }

        if(isValid(i,j-1,board)){
            int[] result=solve(i,j-1,board);
            leftScore=result[0];leftPaths=result[1];
            if(leftPaths>0)leftScore+=getIntFromChar(ch);
        }

        if(isValid(i-1,j-1,board)){
            int[] result=solve(i-1,j-1,board);
            diagScore=result[0];diagPaths=result[1];
            if(diagPaths>0)diagScore+=getIntFromChar(ch);
        }

        int bestScore=0,bestPaths=0;
        if(upScore==leftScore && leftScore==diagScore){
            bestScore=upScore;
            bestPaths=upPaths+leftPaths+diagPaths;
        }else if(upScore==leftScore){
            bestScore=upScore;
            bestPaths=upPaths+leftPaths;
            if(diagScore>bestScore || (diagScore==bestScore && diagPaths>bestPaths)){
                bestScore=diagScore;
                bestPaths=diagPaths;
            }
        }else if(diagScore==leftScore){
            bestScore=leftScore;
            bestPaths=diagPaths+leftPaths;
            if(upScore>bestScore || (upScore==bestScore && upPaths>bestPaths)){
                bestScore=upScore;
                bestPaths=upPaths;
            }
        }else{
            bestScore=upScore;
            bestPaths=upPaths;
            if(diagScore>bestScore || (diagScore==bestScore && diagPaths>bestPaths)){
                bestScore=diagScore;
                bestPaths=diagPaths;
            }
            if(leftScore>bestScore || (leftScore==bestScore && leftPaths>bestPaths)){
                bestScore=leftScore;
                bestPaths=leftPaths;
            }
        }
        tScores[i][j]=bestScore;
        tPaths[i][j]=(int)(((long)bestPaths)%MOD);
        return new int[]{tScores[i][j],tPaths[i][j]};
    }

    public int[] pathsWithMaxScore(List<String> board) {
        n=board.size();
        tScores=new int[n][n];
        tPaths=new int[n][n];

        for(int[] row:tScores)Arrays.fill(row,-1);

        int[] result=solve(n-1,n-1,board);
        return new int[]{result[0],result[1]%MOD};
    }
}