class Solution {
    public int minDeletionSize(String[] strs) {
        int rows=strs.length;
        int col=strs[0].length();

        int deleted=0;
        boolean[] alreadySorted=new boolean[rows];

        for(int j=0;j<col;j++){
            boolean delete=false;
            for(int i=0;i<rows-1;i++){
                if(!alreadySorted[i] && strs[i].charAt(j)>strs[i+1].charAt(j)){
                    deleted++;
                    delete=true;
                    break;
                }
            }
            if(delete){
                continue;
            }
            for(int i=0;i<rows-1;i++){
                alreadySorted[i]=alreadySorted[i]||(strs[i].charAt(j)<strs[i+1].charAt(j));
            }
        }
        return deleted;
    }
}