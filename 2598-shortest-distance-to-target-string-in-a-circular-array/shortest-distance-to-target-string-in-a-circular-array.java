class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int result=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(words[i].equals(target)){
                int straightInd=Math.abs(i-startIndex);
                int circularInd=n-straightInd;

                result=Math.min(result,Math.min(straightInd,circularInd));
            }
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}