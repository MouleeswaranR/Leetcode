class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer,List<int[]>> timeMeetings=new TreeMap<>();
        for(int[] meeting:meetings){
            int x=meeting[0],y=meeting[1],t=meeting[2];
            timeMeetings.computeIfAbsent(t,k->new ArrayList<>()).add(new int[]{x,y});
        }
        boolean[] knowSecret=new boolean[n];
        knowSecret[0]=true;
        knowSecret[firstPerson]=true;
        for(int time:timeMeetings.keySet()){

            Map<Integer,List<Integer>> meet=new HashMap<>();
            for(int[] meeting:timeMeetings.get(time)){
                int x=meeting[0],y=meeting[1];
                meet.computeIfAbsent(x,k->new ArrayList<>()).add(y);
                meet.computeIfAbsent(y,k->new ArrayList<>()).add(x);
            }

            Set<Integer> start=new HashSet<>();
            for(int[] meeting:timeMeetings.get(time)){
                int x=meeting[0],y=meeting[1];
                if(knowSecret[x]){
                    start.add(x);
                }
                 if(knowSecret[y]){
                    start.add(y);
                }
            }

            Queue<Integer> q=new LinkedList<>(start);
            while(!q.isEmpty()){
                int person=q.poll();
                for(int nextMeet:meet.getOrDefault(person,new ArrayList<>())){
                    if(!knowSecret[nextMeet]){
                        q.add(nextMeet);
                        knowSecret[nextMeet]=true;
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(knowSecret[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}