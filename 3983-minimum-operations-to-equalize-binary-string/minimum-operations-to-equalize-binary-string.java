class Solution {
    public int minOperations(String s, int k) {
        int n=s.length();

        int startZeros=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0')startZeros++;
        }

        if(startZeros==0)return 0;

        int[] operations=new int[n+1];
        Arrays.fill(operations,-1);

        TreeSet<Integer> evenSet=new TreeSet<>();
        TreeSet<Integer> oddSet=new TreeSet<>();

        Queue<Integer> queue=new LinkedList<>();

        for(int count=0;count<=n;count++){
            if(count%2==0){
                evenSet.add(count);
            }else{
                oddSet.add(count);
            }
        }
        queue.offer(startZeros);
        operations[startZeros]=0;
        if(startZeros%2==0){
            evenSet.remove(startZeros);
        }else{
            oddSet.remove(startZeros);
        }

        while(!queue.isEmpty()){
            int z=queue.poll();

            int minNewZ=z+k-2*Math.min(k,z);
            int maxNewZ=z+k-2*Math.max(0,k-n+z);

            TreeSet<Integer> currSet=minNewZ%2==0?evenSet:oddSet;

            Integer val=currSet.ceiling(minNewZ);

            while(val!=null && val<=maxNewZ){
                int newZ=val;

                operations[newZ]=operations[z]+1;

                if(newZ==0)return operations[newZ];

                queue.offer(newZ);

                currSet.remove(val);

                val=currSet.ceiling(minNewZ);
            }
        }

        return -1;
    }
}