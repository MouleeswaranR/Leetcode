class Solution {
    String b;
    HashMap<String,Integer> mpp;
    List<List<String>> ans;
    public void dfs(String word,List<String> seq){
        if(word.equals(b)){
            List<String> temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        int steps=mpp.get(word);
        for(int i=0;i<word.length();i++){
            for(char c='a';c<='z';c++){
                char[] arr=word.toCharArray();
                arr[i]=c;
                String str=new String(arr);
                if(mpp.containsKey(str) && mpp.get(str)+1==steps){
                    seq.add(str);
                    dfs(str,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        b=beginWord;
        st.remove(beginWord);
        mpp=new HashMap<>();
        mpp.put(beginWord,1);
        while(!q.isEmpty()){
            String word=q.peek();
            int steps=mpp.get(word);
            q.remove();
            if(word.equals(endWord))break;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr=word.toCharArray();
                    arr[i]=ch;
                    String str=new String(arr);
                    if(st.contains(str)){
                        q.add(str);
                        st.remove(str);
                        mpp.put(str,steps+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(mpp.containsKey(endWord)){
            List<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
}