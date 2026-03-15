class Fancy {
    long M=1_000_000_007;

    ArrayList<Long> seq=new ArrayList<>();
    long mult=1;
    long add=0;

    public long power(long a ,long b){
        if(b==0)return 1;

        long half=power(a,b/2);
        long result=(half*half)%M;

        if(b%2==1){
            result=(result*a)%M;
        }
        return result;
    }

    public Fancy() {
        
    }
    
    public void append(int val) {
        long x=((val-add)%M+M)*power(mult,M-2)%M;
        seq.add(x);
    }
    
    public void addAll(int inc) {
        add=(add+inc)%M;
    }
    
    public void multAll(int m) {
        mult=(mult*m)%M;
        add=(add*m)%M;
    }
    
    public int getIndex(int idx) {
        if (idx >= seq.size())
            return -1;
        return (int)((seq.get(idx)*mult+add)%M);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */