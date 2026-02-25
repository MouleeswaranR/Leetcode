class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k){
            return false;
        }


        int uniqueSub=1<<k; //pow(2,k)

        Set<String> substrings=new HashSet<>();
        for(int i=k;i<=s.length();i++){
            String sub=s.substring(i-k,i);

            if(!substrings.contains(sub)){
                substrings.add(sub);
                uniqueSub--;
            }

            if(uniqueSub==0)return true;
        }
        return false;
    }
}