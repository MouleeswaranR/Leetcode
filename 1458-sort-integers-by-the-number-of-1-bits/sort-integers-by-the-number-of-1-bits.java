class Solution {
    public int[] sortByBits(int[] arr) {
        int MAGIC_NUMBER=10001;

        for(int i=0;i<arr.length;i++){
            arr[i]+=Integer.bitCount(arr[i])*MAGIC_NUMBER;

        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            arr[i]%=MAGIC_NUMBER;
        }
        return arr;
    }
}