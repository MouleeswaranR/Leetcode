class Pair{
    String first;
    int second;
    public Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<>();
        for(String str:wordList){
            st.add(str);
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(endWord))return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedArr=word.toCharArray();
                    replacedArr[i]=ch;
                    String replaceWord=new String(replacedArr);
                    if(st.contains(replaceWord)){
                        st.remove(replaceWord);
                        q.add(new Pair(replaceWord,steps+1));
                    }
                }
            }

        }
        return 0;
    }
}