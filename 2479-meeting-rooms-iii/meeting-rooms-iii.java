class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> freeRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            freeRooms.offer(new long[]{0, i});
        }

        
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                long[] curr = occupiedRooms.poll();
                curr[0] = 0;
                freeRooms.offer(curr);
            }

          
            if (!freeRooms.isEmpty()) {
                long[] curr = freeRooms.poll();
                freq[(int)curr[1]]++;
                curr[0] = end;
                occupiedRooms.offer(curr);
            } else {
                long[] curr = occupiedRooms.poll();
                freq[(int)curr[1]]++;
                curr[0] += (end - start);
                occupiedRooms.offer(curr);
            }
        }

        int maxMeetings = 0;
        int maxMeetingRoom = 0;
        for (int i = 0; i < n; i++) {
            if (freq[i] > maxMeetings) {
                maxMeetings = freq[i];
                maxMeetingRoom = i;
            }
        }
        return maxMeetingRoom;
    }
}