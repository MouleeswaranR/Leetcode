class Solution {
    String str;
    int n;
    long[][] totalNumbers;
    long[][] totalWavinessScores;
    boolean[][] visited;

    public long[] solve(int curr,int prevPrev,int prev,boolean isLimited,boolean isLeadingZero){
        if(curr==n){
            return new long[]{1,0};//found one last digit with no waviness score
        }

        int key=(prevPrev<0?0:prevPrev)*10+(prev<0?0:prev);

        if(!isLimited && !isLeadingZero && prevPrev>=0 && prev>=0 ){
            if(visited[curr][key]){
                return new long[]{totalNumbers[curr][key],totalWavinessScores[curr][key]};
            }
        }

        long totalNumber=0,totalWavinessScore=0;
        int limitDigit=isLimited?str.charAt(curr)-'0':9;

        for(int digit=0;digit<=limitDigit;digit++){
            boolean isNewLeadingZero=isLeadingZero && (digit==0);
            int newPrevPrev=prev;
            int newPrev=isNewLeadingZero ? -1 : digit;

            long[] result=solve(curr+1,newPrevPrev,newPrev,isLimited &&(digit==limitDigit),isNewLeadingZero);

            long remNumbers=result[0],remWavinessScore=result[1];

            if(!isNewLeadingZero && prevPrev>=0 && prev>=0){
                boolean isPeak=(prevPrev<prev && prev>digit);
                boolean isValley=(prevPrev>prev && prev<digit);

                if(isPeak||isValley){
                    totalWavinessScore+=remNumbers;
                }
            }

            totalNumber+=remNumbers;
            totalWavinessScore+=remWavinessScore;
        }

        if(!isLimited && !isLeadingZero && prevPrev>=0 && prev>=0 ){
            totalNumbers[curr][key]=totalNumber;
            totalWavinessScores[curr][key]=totalWavinessScore;
            visited[curr][key]=true;
        }

        return new long[]{totalNumber,totalWavinessScore};
    }

    public long func(long num){
        if(num<100)return 0;
        
        totalNumbers=new long[16][100];
        totalWavinessScores=new long[16][100];
        visited=new boolean[16][100];

        str=Long.toString(num);
        n=str.length();

        long[] result=solve(0,-1,-1,true,true);//{totalNumbers,totalWavinessScore}
        return result[1];
    }

    public long totalWaviness(long num1, long num2) {
        return func(num2)-func(num1-1);
    }
}