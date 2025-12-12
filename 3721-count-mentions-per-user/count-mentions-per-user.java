class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentionCount=new int[numberOfUsers];
        int[] offlineTime=new int[numberOfUsers];

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }
            return Integer.compare(t1, t2);
        });

        for(List<String> event:events){
            if(event.get(0).equals("MESSAGE")){
                applyMessageEvent(event,mentionCount,offlineTime);
            }else if(event.get(0).equals("OFFLINE")){
                int timeStamp=Integer.parseInt(event.get(1));
                int id=Integer.parseInt(event.get(2));
                offlineTime[id]=timeStamp;
            }
        }
        return mentionCount;
    }

    public void applyMessageEvent(List<String> event,int[] mentionCount,int[] offlineTime){
        int timeStamp=Integer.parseInt(event.get(1));
        String[] ids=event.get(2).split(" ");

        for(String id:ids){
            if(id.equals("ALL")){
                for(int i=0;i<mentionCount.length;i++){
                    mentionCount[i]++;
                }
            }else if(id.equals("HERE")){
                for(int i=0;i<mentionCount.length;i++){
                    if(offlineTime[i]==0||offlineTime[i]+60<=timeStamp){
                        mentionCount[i]++;
                    }
                }
            }else{
                int userId=Integer.parseInt(id.substring(2));
                mentionCount[userId]++;
            }
        }
    }
}