class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(pattern.length()!=words.length)return false;
        Map<Character,String> map=new HashMap<>();
        Set<String> used=new HashSet<>();
        int ind=0;
        for(char ch:pattern.toCharArray()){
            if(!map.containsKey(ch)){
                if(used.contains(words[ind]))return false;
                map.put(ch,words[ind]);
                used.add(words[ind]);
            }else if( !map.get(ch).equals(words[ind])){
            return false;
            }
            ind++;
        }

        return true;
    }
}