class FindSumPairs {
    int[] n1, n2;
    Map<Integer, Integer> mpp = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for (int num : n2) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        // Fixing the decrement logic
        mpp.put(n2[index], mpp.get(n2[index]) - 1);
        if (mpp.get(n2[index]) == 0) {
            mpp.remove(n2[index]);
        }
        n2[index] += val;
        mpp.put(n2[index], mpp.getOrDefault(n2[index], 0) + 1);
    }

    public int count(int tot) {
        int cnt = 0;
        for (int num : n1) {
            cnt += mpp.getOrDefault(tot - num, 0);
        }
        return cnt;
    }
}
