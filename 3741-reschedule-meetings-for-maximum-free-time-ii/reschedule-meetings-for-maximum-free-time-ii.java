class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int getFreeTimeByRescheduling(int i, List<Pair> top3, int[] newStart, int[] newEnd) {
        int lastEnd = i == 0 ? 0 : newEnd[i - 1];
        int nextStart = newStart[i + 1];
        int meetDur = newEnd[i] - newStart[i];
        int originalGap = nextStart - lastEnd;

        for (Pair pair : top3) {
            if (pair.first >= meetDur && pair.second != i && pair.second != i + 1) {
                return originalGap;
            }
        }
        return originalGap - meetDur;
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length + 1;
        int[] newStart = new int[n];
        int[] newEnd = new int[n];

        for (int i = 0; i < n - 1; i++) {
            newStart[i] = startTime[i];
            newEnd[i] = endTime[i];
        }
        newStart[n - 1] = eventTime;
        newEnd[n - 1] = eventTime;

        List<Pair> top3 = new ArrayList<>();
        top3.add(new Pair(newStart[0], 0));
        top3.add(new Pair(-1, -1));
        top3.add(new Pair(-1, -1));

        for (int i = 1; i < n; i++) {
            int gap = newStart[i] - newEnd[i - 1];
            Pair pair = new Pair(gap, i);
            if (gap > top3.get(2).first) {
                top3.set(2, pair);
                top3.sort((a, b) -> b.first - a.first);
            }
        }

        int maxFreeTime = 0;
        for (int i = 0; i < n - 1; i++) {
            int time = getFreeTimeByRescheduling(i, top3, newStart, newEnd);
            maxFreeTime = Math.max(maxFreeTime, time);
        }

        return maxFreeTime;
    }
}
