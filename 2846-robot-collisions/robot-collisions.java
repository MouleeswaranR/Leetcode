class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        Integer[] indices=new Integer[n];

        for(int i=0;i<n;i++)indices[i]=i;


        Arrays.sort(indices,(i,j)->Integer.compare(positions[i],positions[j]));

        Stack<Integer> st=new Stack<>();

        List<Integer> ans=new ArrayList<>();

        for(int currIdx:indices){
            if (directions.charAt(currIdx)=='R'){
                st.push(currIdx);
            }else{
                while(!st.isEmpty() && healths[currIdx]>0){

                    int topIdx=st.pop();

                    if(healths[topIdx]>healths[currIdx]){
                        healths[topIdx]-=1;
                        healths[currIdx]=0;
                        st.push(topIdx);
                    }else if(healths[topIdx]<healths[currIdx]){
                        healths[currIdx]-=1;
                        healths[topIdx]=0;
                    }else{
                         healths[currIdx]=0;
                        healths[topIdx]=0;
                    }
                }
            }
        }


        for(int i=0;i<n;i++){
            if(healths[i]>0){
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}