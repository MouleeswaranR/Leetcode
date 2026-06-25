//Binary Lifting

class TreeAncestor {
    private final int[][] ancestorTable;//stores ancestor of each node for 2^i jumps
    //stores [nodes][jump_power]
    private final int LOG;//maximum number of jumps can be done on given tree
    public TreeAncestor(int n, int[] parent) {
        LOG=(int)(Math.log(n)/Math.log(2))+1;

        ancestorTable=new int[n][LOG];

        //initialse veerything with -1
        for(int row=0;row<n;row++){
            Arrays.fill(ancestorTable[row],-1);
        }

        //parent is immediate ancestor for each node, fill it in first column of ancestor table which is 2^0 jump=1 jump
        for(int node=0;node<n;node++){
            ancestorTable[node][0]=parent[node];
        }

        //filling jth jump ancestor for each node(filling one columns all row)
        for(int jump=1;jump<LOG;jump++){
            for(int node=0;node<n;node++){
                //previous jump=2^j-1th jump (2^j=2^j-1+2^j-1)
                int prevJump=ancestorTable[node][jump-1];

                //if that is -1 not reachable
                if(prevJump!=-1){
                    ancestorTable[node][jump]=ancestorTable[prevJump][jump-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        
        //jumping using set bit of given k
        for(int jump=0;jump<LOG;jump++){//only LOG no of jumps possible on tree,so check only bits of k until LOG
            if((k & (1<<jump))!=0){//check kth bit set, if set, there is a jump
                node=ancestorTable[node][jump];
                if(node==-1)return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */