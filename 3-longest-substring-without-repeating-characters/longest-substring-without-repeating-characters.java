// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length()==0)return 0;
//         Map<Character,Integer> mpp=new HashMap<>();
//         int left=0,right=0,maxlen=0;
//         while(right<s.length()){
//             if(mpp.containsKey(s.charAt(right))){
//                 if(mpp.get(s.charAt(right))>=left){
//                     left=mpp.get(s.charAt(right))+1;
//                 }
//             }
//             mpp.put(s.charAt(right),right);
//             maxlen=Math.max(maxlen,right-left+1);
//             right++;
//         }
//         return maxlen;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
       int left=0,right=0,maxlen=0;
       int[] vis=new int[256];
       while(right<s.length()){
        char ch=s.charAt(right);
        vis[ch]++;
        while(vis[ch]>1){
            vis[s.charAt(left)]--;
            left++;
        }
        maxlen=Math.max(maxlen,right-left+1);
        right++;
         }
         return maxlen;
    }
}