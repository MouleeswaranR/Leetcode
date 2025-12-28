class Solution {
    public long minimumCost(
        int cost1, int cost2, int costBoth,
        int need1, int need2
    ) {

        if (need1 == 0 && need2 == 0) return 0;

        if (costBoth >= cost1 + cost2) {
            return (long) need1 * cost1 + (long) need2 * cost2;
        }

        int common = Math.min(need1, need2);

        long option1 =
                (long) common * costBoth +
                (long) (need1 - common) * cost1 +
                (long) (need2 - common) * cost2;

        int maxNeed = Math.max(need1, need2);
        long option2 = (long) maxNeed * costBoth;

        return Math.min(option1, option2);
    }
}
