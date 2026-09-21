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
class Solution {
    public int distributeCoins(TreeNode root) {
        if(root==null )return 0;

        int[] moves={0};
    solve(root,moves);
        return moves[0];
    }
    public int solve(TreeNode node,int[] moves){
        if(node==null)return 0;

        int left=solve(node.left,moves);
        int right=solve(node.right,moves);

        moves[0]+=Math.abs(left)+Math.abs(right);

        return (left+right+node.val)-1;
    }
}