class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();

        //getting frequency of all characters from given string s
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        //max heap based on frequency of characters(descending order)charcter with highest frequnecy at top
        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>(
            (a,b)->b.getValue()-a.getValue()
        );

        pq.addAll(map.entrySet());//add all entries of map to priority queue-max heap

        StringBuilder result=new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry=pq.poll();

            char ch=entry.getKey();
            int count=entry.getValue();

            //adding that character its frequency times to output
            for(int i=0;i<count;i++){
                result.append(ch);
            }
        }

        return result.toString();
    }
}