//Line sweep
class MyCalendarTwo {
    private TreeMap<Integer,Integer> events;

    public MyCalendarTwo() {
        events=new TreeMap<>();//stores time with delta(+1,-1)
    }
    
    public boolean book(int startTime, int endTime) {
        events.put(startTime,events.getOrDefault(startTime,0)+1);//putting start time with +1
        events.put(endTime,events.getOrDefault(endTime,0)-1);//putting end time with -1

        int delta=0;

        //iterate through all values
        for(int value:events.values()){
            delta+=value;

            //if a triplet is met,remove current start and end time ,return false
            if(delta>2){
                events.put(startTime,events.getOrDefault(startTime,0)-1);//removing startTime
                if(events.get(startTime)==0){
                    events.remove(startTime);
                }
                events.put(endTime,events.getOrDefault(endTime,0)+1);//removing endTime
                if(events.get(endTime)==0){
                    events.remove(endTime);
                }

                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */