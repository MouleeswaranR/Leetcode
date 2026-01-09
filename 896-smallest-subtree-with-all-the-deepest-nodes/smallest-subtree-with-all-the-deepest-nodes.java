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
    int depth;

    public Pair(TreeNode node,int val){
        this.node=node;
        this.depth=val;
    }
}
class Solution {
    public Pair dfs(TreeNode node){
        if(node==null){
            return new Pair(node,0);
        }

        Pair leftSubTree=dfs(node.left);
        Pair rightSubTree=dfs(node.right);

        if(leftSubTree.depth>rightSubTree.depth){
            return new Pair(leftSubTree.node,leftSubTree.depth+1);
        }

         if(leftSubTree.depth<rightSubTree.depth){
            return new Pair(rightSubTree.node,rightSubTree.depth+1);
        }

        return new Pair(node,rightSubTree.depth+1);
        
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}