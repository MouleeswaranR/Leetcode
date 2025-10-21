class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> pointsCover = new HashMap<>();
        Map<Integer, Integer> cntPoints = new HashMap<>();
        Set<Integer> points = new TreeSet<>(); 

        for (int num : nums) {
            cntPoints.put(num, cntPoints.getOrDefault(num, 0) + 1);
            pointsCover.put(num - k, pointsCover.getOrDefault(num - k, 0) + 1);
            pointsCover.put(num + k + 1, pointsCover.getOrDefault(num + k + 1, 0) - 1);
            points.add(num);
            points.add(num - k);
            points.add(num + k + 1);
        }

        int res = 0;
        int pointsCoverThisPoint = 0;

        for (int point : points) {
            pointsCoverThisPoint += pointsCover.getOrDefault(point, 0);
            res = Math.max(res, cntPoints.getOrDefault(point, 0) + 
                        Math.min(pointsCoverThisPoint - cntPoints.getOrDefault(point, 0), numOperations));
        }

        return res;
    }
}