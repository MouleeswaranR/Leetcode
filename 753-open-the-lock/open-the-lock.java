
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if ("0000".equals(target)) return 0;

        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer("0000");
        seen.add("0000");

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                if (dead.contains(cur)) continue;     
                if (cur.equals(target)) return steps;   

              
                char[] cs = cur.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char orig = cs[i];
                    int d = orig - '0';

                    cs[i] = (char) ('0' + ((d + 1) % 10));
                    String up = new String(cs);
                    if (!dead.contains(up) && seen.add(up)) q.offer(up);

                    cs[i] = (char) ('0' + ((d + 9) % 10));
                    String down = new String(cs);
                    if (!dead.contains(down) && seen.add(down)) q.offer(down);

                    cs[i] = orig;
                }
            }
            steps++;
        }
        return -1; 
    }
}