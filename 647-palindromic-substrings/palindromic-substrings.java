//Simple-Check for All Substrings
//Time Complexity: O(n^3)
//Space Complexity:O(1)

// class Solution {
//     public int countSubstrings(String s) {
//         int count=0;
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(check(i,j,s)){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }

//     public boolean check(int i,int j,String s){
        
//         if(i>=j){
//             return true;
//         }
//         if(s.charAt(i)==s.charAt(j)){
//             return check(i+1,j-1,s);
//         }
//         return false;
//     }
// }


//Memoization
//Time Complexity: O(n^2)
//Space Complexity:O(n^2)
// class Solution {

//     public boolean check(int i,int j,String s ,int[][] dp){
//         if(i>=j)return true;

//         if(dp[i][j]!=-1){
//             return dp[i][j]==1;
//         }
//         if(s.charAt(i)==s.charAt(j)){
//             boolean val=check(i+1,j-1,s,dp);
//             if(val==true){
//                 dp[i][j]=1;
//             }else{
//                 dp[i][j]=0;
//             }
//             return val;
//         }
//         dp[i][j]=0;
//         return false;
//     }
//     public int countSubstrings(String s) {
//         int n=s.length();
//         int[][] dp=new int[n][n];

//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }

//         int count=0;

//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++){
//                 if(check(i,j,s,dp)){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

//Tabulation
//Time Complexity: O(n^2)
//Space Complexity:O(n^2)
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        int count=0;
        for(int L=1;L<=n;L++){
            for(int i=0;i+L<=n;i++){
                int j=i+L-1;

                if(i==j){
                    dp[i][j]=true;
                }else if(i+1==j){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
                }

                if(dp[i][j]){
                    count++;
                }
            }

        }
        return count;
    }
}