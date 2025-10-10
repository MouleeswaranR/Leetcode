class Solution {
    public int findClosest(int x, int y, int z) {
        int xReach=Math.abs(x-z),yReach=Math.abs(y-z);
        if(xReach==yReach)return 0;
        return xReach<yReach?1:2;
    }
}