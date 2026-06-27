class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> events=new TreeMap<>();

        for(int[] trip:trips){
            int passengers=trip[0],start=trip[1],end=trip[2];

            events.put(start,events.getOrDefault(start,0)+passengers);
            events.put(end,events.getOrDefault(end,0)-passengers);
        }

        int currPassengers=0;

        for(int value:events.values()){
            currPassengers+=value;
            if(currPassengers>capacity){
                return false;
            }
        }

        return true;
    }
}