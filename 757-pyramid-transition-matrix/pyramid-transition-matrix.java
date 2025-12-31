class Solution {
    private Map<String,Boolean> memo=new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,ArrayList<Character>> mp=new HashMap<>();

        for(String pattern:allowed){
            String key=pattern.substring(0,2);
            char value=pattern.charAt(2);
            mp.computeIfAbsent(key,k->new ArrayList<>()).add(value);
        }

        return solve(bottom,mp,0,new StringBuilder());
    }

    public boolean solve(String curr,Map<String,ArrayList<Character>> mp,int idx,StringBuilder above){

        if(curr.length()==1){
            return true;
        }

        String key=curr+"_"+idx+"_"+above.toString();
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(idx==curr.length()-1){
            boolean result=solve(above.toString(),mp,0,new StringBuilder());
            memo.put(key,result);
            return result;
        }
        String pair=curr.substring(idx,idx+2);
        if(!mp.containsKey(pair)){
            memo.put(key,false);
            return false;
        }

        for(char ch:mp.get(pair)){
            above.append(ch);
            if(solve(curr,mp,idx+1,above)){
                memo.put(key,true);
                return true;
            }
            above.deleteCharAt(above.length()-1);
        }
        memo.put(key,false);
        return false;
    }
}