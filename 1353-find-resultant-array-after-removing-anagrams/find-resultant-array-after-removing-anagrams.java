class Solution {
    public boolean isAnagram(String str1,String str2){
        int m=str1.length(),n=str2.length();
        if(n!=m)return false;
        int[] count=new int[26];
        for(int i=0;i<n;i++){
            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0)return false;
        }

        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans=new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(isAnagram(words[i-1],words[i])){
                continue;
            }else{
                ans.add(words[i]);
            }
        }
        return ans;
    }
}