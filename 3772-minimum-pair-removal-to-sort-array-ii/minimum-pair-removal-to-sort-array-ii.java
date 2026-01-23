class Solution {
    class Pair {
        long sum;
        int left_idx;
        
        Pair(long sum, int left_idx) {
            this.sum = sum;
            this.left_idx = left_idx;
        }
    }
    
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        boolean already_sorted = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                already_sorted = false;
                break;
            }
        }
        if (already_sorted) return 0;
        
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        
        boolean[] removed = new boolean[n];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.sum < b.sum) return -1;
                if (a.sum > b.sum) return 1;
                return Integer.compare(a.left_idx, b.left_idx);
            }
        });
        
        int sorted_pairs = 0;
        for (int i = 1; i < n; i++) {
            pq.add(new Pair(arr[i - 1] + arr[i], i - 1));
            if (arr[i] >= arr[i - 1]) sorted_pairs++;
        }
        
        if (sorted_pairs == n - 1) return 0;
        
        int[] prev = new int[n], next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        int remaining = n, operations = 0;
        while (remaining > 1) {
            Pair top = pq.poll();
            if (top == null) break;
            
            long sum = top.sum;
            int left = top.left_idx, right = next[left];
            
            if (right >= n || removed[left] || removed[right] || 
                arr[left] + arr[right] != sum) {
                continue;
            }
            
            int pre = prev[left], nxt = next[right];
            
            if (arr[left] <= arr[right]) sorted_pairs--;
            if (pre != -1 && arr[pre] <= arr[left]) sorted_pairs--;
            if (nxt != n && arr[right] <= arr[nxt]) sorted_pairs--;
            
            arr[left] = sum;
            removed[right] = true;
            remaining--;
            operations++;
            
            if (pre != -1) {
                pq.add(new Pair(arr[pre] + arr[left], pre));
                if (arr[pre] <= arr[left]) sorted_pairs++;
                next[pre] = left;
                prev[left] = pre;
            } else {
                prev[left] = -1;
            }
            
            if (nxt != n) {
                prev[nxt] = left;
                next[left] = nxt;
                pq.add(new Pair(arr[left] + arr[nxt], left));
                if (arr[left] <= arr[nxt]) sorted_pairs++;
            } else {
                next[left] = n;
            }

            if (sorted_pairs == remaining - 1) {
                return operations;
            }
        }
        
        return operations;
    }
}