class MyCalendarThree {
    private TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map=new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);

        int count=0;
        int maxIntersections=0;

        for(int value:map.values()){
            count+=value;
            maxIntersections=Math.max(maxIntersections,count);
        }

        return maxIntersections;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */