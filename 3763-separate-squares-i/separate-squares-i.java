class Solution {
    public boolean checkY(int[][] squares,double midY,double total){
        double bottomArea=0.0;

        for(int[] square:squares){
            double y=square[1],l=square[2];
            
            double bottomY=y,topY=y+l;

            if(midY>topY){
                bottomArea+=(l*l);
            }else if(midY>bottomY){
                bottomArea+=(l*(midY-bottomY));
            }
        }
        return bottomArea>=total/2.0;
    }
    public double separateSquares(int[][] squares) {
        double low=Double.MIN_VALUE;
        double high=-Double.MAX_VALUE;
        double total=0;

        for(int[] square:squares){
            double y=square[1],l=square[2];

            total+=(l*l);
            low=Math.min(low,y);
            high=Math.max(high,y+l);
        }

        double resultY=0.0;

        while(high-low>1e-5){
            double midY=low+(high-low)/2.0;
            resultY=midY;

            if(checkY(squares,midY,total)){
                high=midY;
            }else{
                low=midY;
            }
        }
        return resultY;
    }
}