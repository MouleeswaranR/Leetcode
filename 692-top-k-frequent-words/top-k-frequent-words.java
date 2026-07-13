class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> freq=new HashMap<>();

        for(String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):Integer.compare(b.getValue(),a.getValue()));

        pq.addAll(freq.entrySet());

        List<String> ans=new ArrayList<>();
        while(k-->0){
            Map.Entry<String,Integer> entry=pq.poll();
            ans.add(entry.getKey());
        }
        return ans;
    }
}