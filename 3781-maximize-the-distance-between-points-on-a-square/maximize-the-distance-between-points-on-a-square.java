import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {

        List<Long> arr = new ArrayList<>();

        for (int[] p : points) {
            long x = p[0], y = p[1];

            if (y == 0) arr.add(x);
            else if (x == side) arr.add((long)side + y);
            else if (y == side) arr.add(3L * side - x);
            else arr.add(4L * side - y);
        }

        Collections.sort(arr);
        int n = arr.size();

        long low = 0, high = side, ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            if (!notValid(arr, n, k, mid, side)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean notValid(List<Long> arr, int n, int k, long d, int side) {
        for (int i = 0; i < n; i++) {
            int ptr = i, cnt = 1;

            while (cnt < k) {
                long target = arr.get(ptr) + d;

                int j = lowerBound(arr, target);

                if (j == n) break;

                ptr = j;
                cnt++;

                if (d + arr.get(ptr) > arr.get(i) + 4L * side) {
                    cnt = 0;
                    break;
                }
            }

            if (cnt == k) return false;
        }

        return true;
    }

    private int lowerBound(List<Long> arr, long target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}