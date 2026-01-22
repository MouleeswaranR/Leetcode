//Memoization
// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

// class Solution {
//     public boolean solve(int i,int j,String s,int[][] dp){
//         if(i>=j){
//             return true;
//         }

//         if(dp[i][j]!=-1){
//             return dp[i][j]==1;
//         }

//         if(s.charAt(i)==s.charAt(j)){
//             dp[i][j]=solve(i+1,j-1,s,dp)?1:0;
//         }else{
//             dp[i][j]=0;
//         }

//         return dp[i][j]==1;
//     }
//     public String longestPalindrome(String s) {
//         int n=s.length();

//         int[][] dp=new int[n][n];


//         for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
//         int maxlen=Integer.MIN_VALUE;
//         int sp=-1;


//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(solve(i,j,s,dp) && j-i+1>maxlen){
//                     maxlen=j-i+1;
//                     sp=i;
//                 }
//             }
//         }
//         return s.substring(sp,sp+maxlen);
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] t=new boolean[n][n];

        int maxLen=1;
        int start=0;

        for (int i = 0; i < n; i++) {
            t[i][i] = true;
        }

        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j=i+L-1;
                if (s.charAt(i) == s.charAt(j) && (t[i + 1][j - 1] || L == 2)) {
                    t[i][j] = true;
                    if (L > maxLen) {
                        maxLen = L;
                        start = i;
                    }
                }
                }
            }
            return s.substring(start,start+maxLen);
        }
       
    }