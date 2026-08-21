class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left=0,right=tokens.length-1;

        Arrays.sort(tokens);

        int currScore=0,maxScore=0;

        while(left<=right){
            if(power>=tokens[left]){
                currScore++;
                maxScore=Math.max(maxScore,currScore);
                power-=tokens[left];
                left++;
            }else if (currScore>=1){
                currScore--;
                power+=tokens[right];
                right--;
            }else{
                return maxScore;
            }
        }

        return maxScore;
    }
}