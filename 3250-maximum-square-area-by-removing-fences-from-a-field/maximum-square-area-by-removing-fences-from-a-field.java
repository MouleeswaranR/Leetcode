class Solution {
    private static final int MOD=1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hf=new ArrayList<>();
        List<Integer> vf=new ArrayList<>();

        for(int x:hFences)hf.add(x);
        for(int x:vFences)vf.add(x);

        hf.add(1);
        hf.add(m);
        vf.add(1);
        vf.add(n);

        Collections.sort(hf);
        Collections.sort(vf);

        Set<Integer> widths=new HashSet<>();
        for(int i=0;i<vf.size();i++){
            for(int j=i+1;j<vf.size();j++){
                widths.add(vf.get(j)-vf.get(i));
            }
        }

        int maxSize=0;
        for(int i=0;i<hf.size();i++){
            for(int j=i+1;j<hf.size();j++){
                int height=hf.get(j)-hf.get(i);
                if(widths.contains(height)){
                    maxSize=Math.max(maxSize,height);
                }
            }
        }

        if(maxSize==0)return -1;

        long ans=(long)maxSize*maxSize;
        return (int) (ans%MOD);
    }
}