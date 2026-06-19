class Solution {
    public int largestAltitude(int[] gain) {
        int currAlt=0,maxAlt=0;

        for(int alt:gain){
            currAlt+=alt;

            maxAlt=Math.max(maxAlt,currAlt);
        }

        return maxAlt;
    }
}