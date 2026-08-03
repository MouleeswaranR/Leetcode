class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;

        int a=0,b=0,c=0;
        for(int i=n-1;i>=0;i--){
            int result=Integer.MIN_VALUE;
            result=Math.max(result,stoneValue[i]-a);

            if(i+1<n)
                 result=Math.max(result,stoneValue[i]+stoneValue[i+1]-b);
            
            if(i+2<n)
                result=Math.max(result,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-c);

            c=b;
            b=a;
            a=result;
        }

        int diff=a;

        if(diff<0){
            return "Bob";
        }else if(diff>0){
            return "Alice";
        }

        return "Tie";
    }
}