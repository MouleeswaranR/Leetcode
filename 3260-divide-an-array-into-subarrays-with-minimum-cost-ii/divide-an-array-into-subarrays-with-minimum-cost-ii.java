class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n=nums.length;

        TreeSet<int[]> kMinimum=new TreeSet<>((a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        TreeSet<int[]> remaining=new TreeSet<>((a,b)->{
            if(a[0]!=b[0])return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });

        long sum=0;
        int i=1;

        while(i<n && i-dist<1){
            sum+=nums[i];
            int[] curr=new int[]{nums[i],i};
            kMinimum.add(curr);

            if(kMinimum.size()>k-1){
                int[] largest=kMinimum.pollLast();
                sum-=largest[0];
                remaining.add(largest);
            }
            i++;
        }

        long result=Long.MAX_VALUE;

        while(i<n){
            int[] curr=new int[]{nums[i],i};
            sum+=nums[i];
            kMinimum.add(curr);

            if(kMinimum.size()>k-1){
                int[] largest=kMinimum.pollLast();
                sum-=largest[0];
                remaining.add(largest);
            }

            result=Math.min(result,sum);

            int removeIdx=i-dist;
            int[] toRemove=new int[]{nums[removeIdx],removeIdx};
            if(kMinimum.remove(toRemove)){
                sum-=nums[removeIdx];
                if(!remaining.isEmpty()){
                    int[] promote=remaining.pollFirst();
                    sum+=promote[0];
                    kMinimum.add(promote);
                }
            }else{
                remaining.remove(toRemove);
            }
            i++;
        }

        return nums[0]+result;

    }
}