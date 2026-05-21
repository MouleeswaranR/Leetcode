public class TrieNode{
    TrieNode[] children=new TrieNode[10];
}

class Solution {

    public TrieNode getTrieNode(){
        return new TrieNode();
    }

    public void insert(int num,TrieNode root){
        TrieNode crawl=root;

        String numStr=Integer.toString(num);
        for(char ch:numStr.toCharArray()){
            int idx=ch-'0';
            if(crawl.children[idx]==null){
                crawl.children[idx]=getTrieNode();
            }
            crawl=crawl.children[idx];
        }
    }

    public int search(int num,TrieNode root){
        TrieNode crawl=root;
        String numStr=Integer.toString(num);
        int length=0;

        for(char ch:numStr.toCharArray()){
            int idx=ch-'0';
            if(crawl.children[idx]!=null){
                length++;
                crawl=crawl.children[idx];
            }else{
                break;
            }
        }
        return length;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root=getTrieNode();

        for(int num:arr1){
            insert(num,root);
        }

        int result=0;
        for(int num:arr2){
            result=Math.max(result,search(num,root));
        }

    return result;
    }
}