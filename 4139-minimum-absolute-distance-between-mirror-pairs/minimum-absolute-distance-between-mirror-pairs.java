class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int result=Integer.MAX_VALUE;

        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]) ){
                result=Math.min(result,Math.abs(i-map.get(nums[i])));
            }
            map.put(reverseNumber(nums[i]),i);
        }

        return result==Integer.MAX_VALUE?-1:result;
    }

    public int reverseNumber(int n) {
        int rev = 0;
        
        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }
}