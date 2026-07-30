class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];

        for(char ch:word.toCharArray()){
            freq[ch-'a']++;

        }

        Arrays.sort(freq);

        int result=0;
        int index=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0)continue;
            int count=freq[i];

            int press=(index/8)+1;

            result+=(press*count);
            index++;
        }

        return result;
    }
}