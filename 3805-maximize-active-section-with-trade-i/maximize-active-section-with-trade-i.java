class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int activeCount=0,n=s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')activeCount++;
        }


        List<Integer> inactiveCounts=new ArrayList<>();

        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                int start=i;

                while(i<n && s.charAt(i)=='0')i++;

                inactiveCounts.add(i-start);
            }else{
                i++;
            }
        }

        int maxPair=0;

        for(int j=1;j<inactiveCounts.size();j++){
            maxPair=Math.max(maxPair,inactiveCounts.get(j)+inactiveCounts.get(j-1));
        }

        return activeCount+maxPair;
    }
}