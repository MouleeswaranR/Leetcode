/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
    TreeNode node;
    int nodeLevel;
    public Pair(TreeNode node,int level){
        this.node=node;
        this.nodeLevel=level;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int first=0,last=0;
            int minValInd=q.peek().nodeLevel;
            for(int i=0;i<size;i++){
                Pair pair=q.poll();
                TreeNode node=pair.node;
                int currLevel=pair.nodeLevel-minValInd;
                if(i==0)first=currLevel;
                if(i==size-1)last=currLevel;
                if(node.left!=null){
                    q.add(new Pair(node.left,currLevel*2));

                }
                if(node.right!=null){
                    q.add(new Pair(node.right,currLevel*2+1));

                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
}