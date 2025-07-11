class DisjointSet {
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int u) {
        if (u == parent.get(u)) {
            return u;
        }
        int node = findUpar(parent.get(u));
        parent.set(u, node);
        return node;
    }

    public void UnionBySize(int u, int v) {
        int ulpu = findUpar(u);
        int ulpv = findUpar(v);

        if (ulpu == ulpv) return;

        if (size.get(ulpu) < size.get(ulpv)) {
            parent.set(ulpu, ulpv);
            size.set(ulpv, size.get(ulpv) + size.get(ulpu));
        } else {
            parent.set(ulpv, ulpu);
            size.set(ulpu, size.get(ulpu) + size.get(ulpv));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxrow = -1;
        int maxcol =-1;
        int n = stones.length;

        for(int[] arr:stones){
            maxrow = Math.max(maxrow,arr[0]);
            maxcol = Math.max(maxcol,arr[1]);
        }
        DisjointSet dj = new DisjointSet(maxrow + maxcol +1);
        HashSet<Integer> set = new HashSet();
        for(int[] arr:stones){
           int newcol = maxrow+1 + arr[1];
            dj.UnionBySize(arr[0],newcol);
            set.add(arr[0]);
            set.add(newcol);
        }
        int count=0;
        for(int nodes:set){
            if(nodes == dj.findUpar(nodes)){
                count++;
            }
        }
        return n-count;
    }
}