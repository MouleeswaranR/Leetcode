class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int index : queries) {

            int num = nums[index];
            List<Integer> vec = map.get(num);

            int size = vec.size();

            if (size == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(vec, index);

            int res = Integer.MAX_VALUE;

            int rightIndex = vec.get((pos + 1) % size);
            int d = Math.abs(index - rightIndex);
            res = Math.min(res, Math.min(d, n - d));

            int leftIndex = vec.get((pos - 1 + size) % size);
            d = Math.abs(index - leftIndex);
            res = Math.min(res, Math.min(d, n - d));

            result.add(res);
        }

        return result;
    }
}