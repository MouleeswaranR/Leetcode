//Longest Increasing Subsequence Variant-2

//Recurion+Memoization
//Time Complexity:O(n**2)
//Space Complexity: O(n*n)
// class Solution {

//     public boolean isPredecessor(String prev,String curr){
//         int prevl=prev.length(),currl=curr.length();
//         if(prevl>=currl||currl-prevl!=1)return false;

//         int i=0,j=0;
//         while(i<prevl && j<currl){
//             if(prev.charAt(i)==curr.charAt(j))
//                 i++;
            
//             j++;
//         }
//         return i==prevl;
//     }
//     public int LIS(String[] words,int currIdx,int prevIdx,int[][] dp){
//         if(currIdx>=words.length)return 0;
        
//         if(prevIdx!=-1 && dp[currIdx][prevIdx]!=-1){
//             return dp[currIdx][prevIdx];
//         }
//         int taken=0;
//         if(prevIdx==-1 || isPredecessor(words[prevIdx],words[currIdx])){
//             taken=1+LIS(words,currIdx+1,currIdx,dp);
//         }

//         int skip=LIS(words,currIdx+1,prevIdx,dp);

//         if(prevIdx!=-1){
//             dp[currIdx][prevIdx]=Math.max(taken,skip);
//         }
//         return Math.max(taken,skip);
//     }
//     public int longestStrChain(String[] words) {
//         int n=words.length;
//         int[][] dp=new int[n+1][n+1];
//         for(int i=0;i<=n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         Arrays.sort(words,(s1,s2)->Integer.compare(s1.length(),s2.length()));

//         return LIS(words,0,-1,dp);
//     }
// }


//Tabulation
//Time Complexity:O(n**2)
//Space Complexity: O(n)
class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxVal=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPredeccesor(words[j],words[i])){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxVal=Math.max(maxVal,dp[i]);
                }
            }
        }
        return maxVal;
    }
    public boolean isPredeccesor(String prev,String curr){
        int prevl=prev.length(),currl=curr.length();

        if(prevl>=currl||currl-prevl!=1){
            return false;
        }
       int i = 0, j = 0;

        while (i < prevl && j < currl) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == prevl;
    }
}