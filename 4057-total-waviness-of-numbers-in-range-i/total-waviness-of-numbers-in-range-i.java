class Solution {

    public int findWaiveScore(int num){
        String numStr=Integer.toString(num);
        int len=numStr.length();

        if(len<3)return 0;

        int score=0;
        for(int i=1;i<=len-2;i++){
            if(numStr.charAt(i)>numStr.charAt(i-1) && numStr.charAt(i)>numStr.charAt(i+1))score++;

            if(numStr.charAt(i)<numStr.charAt(i-1) && numStr.charAt(i)<numStr.charAt(i+1))score++;
        }
        return score;
    }

    public int totalWaviness(int num1, int num2) {
        int score=0;

        for(int num=num1;num<=num2;num++){
            score+=findWaiveScore(num);
        }

        return score;
    }
}