class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> ans=new ArrayList<>();

        int minDiff=Integer.MAX_VALUE;

        for(int i=1;i<arr.length;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }

        for(int i=1;i<arr.length;i++){
            int diff=arr[i]-arr[i-1];
            if(minDiff==diff)ans.add(Arrays.asList(arr[i-1],arr[i]));
        }
        return ans;
    }
}