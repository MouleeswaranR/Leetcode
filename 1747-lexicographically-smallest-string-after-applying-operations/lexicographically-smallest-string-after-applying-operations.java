class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> vis=new HashSet<>();
        String smallest=s;
        Deque<String> q=new ArrayDeque<>();
        q.add(s);
        vis.add(s);

        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr.compareTo(smallest)<0)smallest=curr;

            StringBuilder sb=new StringBuilder(curr);
            for(int i=1;i<sb.length();i+=2){
               sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            }
            String added=sb.toString();
            if(vis.add(added))q.offer(added);
            String rotated=curr.substring(curr.length()-b)+curr.substring(0,curr.length()-b);
            if(vis.add(rotated))q.offer(rotated);
        }
        return smallest;
    }
}