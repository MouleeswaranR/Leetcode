class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> geneBanks=new HashSet<>(Arrays.asList(bank));
        if(!geneBanks.contains(endGene))return -1;

        Queue<String> queue=new LinkedList<>();
        int mutationsCount=0;
        //adding startGene in queue
        queue.add(startGene);

        char[] mutations={'A','C','G','T'};

        while(!queue.isEmpty()){
            int levelSize=queue.size();

            for(int i=0;i<levelSize;i++){
                String curr=queue.poll();
                //taking the current gene in queue

                if(curr.equals(endGene))return mutationsCount;
                StringBuilder currGene=new StringBuilder(curr);
                
                //trying to replace all characters in current gene with all types of mutations
                for(int index=0;index<8;index++){
                    char original=currGene.charAt(index);
                    for(char ch:mutations){
                        if(ch==original)continue;
                        currGene.setCharAt(index,ch);
                        String nextGene=currGene.toString();
                        //if nextgene is available in geneBanks,add it to queue and remove it from geneBanks becase the same gene should not be visisted again
                        if(geneBanks.contains(nextGene)){
                            queue.add(nextGene);
                            geneBanks.remove(nextGene);
                        }
                    }
                    //again replacing the character which is changed to its original character
                    currGene.setCharAt(index,original);
                }

            }
            mutationsCount++;
        }
        return -1;
    }
}