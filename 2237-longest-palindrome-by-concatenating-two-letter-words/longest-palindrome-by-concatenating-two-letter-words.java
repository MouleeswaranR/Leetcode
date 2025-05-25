class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> mpp=new HashMap<>();
        for(String word:words){
            mpp.put(word,mpp.getOrDefault(word,0)+1);
        }
        int count=0,alPal=0;
        for(Map.Entry<String,Integer> it:mpp.entrySet()){
            String word=it.getKey();
            int freq=it.getValue();
            String s=new StringBuilder(word).reverse().toString();
            if(word.equals(s)){
                count+=(freq/2)*4;
                if(freq%2==1)alPal=1;
            }else if(word.compareTo(s)<0 && mpp.containsKey(s)){
                count+=Math.min(freq,mpp.get(s))*4;
            }
        }
        return count+alPal*2;
    }
}