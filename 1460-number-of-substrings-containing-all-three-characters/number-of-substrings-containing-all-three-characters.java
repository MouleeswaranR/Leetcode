// class Solution {
//     public int numberOfSubstrings(String s) {
//         int[] freq=new int[3];
//         int count=0;
//         for(int i=0;i<s.length();i++){
//             freq[s.charAt(i)-'a']=i;
//             if(freq[0]>=1&& freq[1]>=1 &&freq[2]>=1){
//                 count+=(1+Math.min(freq[0],Math.min(freq[1],freq[2])));
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int[] freq=new int[3];
        int subarrays=0;

    int left=0,right=0;
    while(right<n){
        freq[s.charAt(right)-'a']++;
        while(freq[0]>0 && freq[1]>0 && freq[2]>0){
            subarrays+=n-right;
            freq[s.charAt(left)-'a']--;
            left++;
        }
        right++;
    }
    return subarrays;
    }
}