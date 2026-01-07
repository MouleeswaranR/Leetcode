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
    long maxProductVal=0;
    static final int MOD=1_000_000_007;
    public int maxProduct(TreeNode root) {
        long totalSum=computeTotalSum(root);
        computeMax(root,totalSum);
        return (int)(maxProductVal%MOD);
    }

    public long computeTotalSum(TreeNode node){
        if(node==null)return 0;
        return node.val+computeTotalSum(node.left)+computeTotalSum(node.right);
    }

    public long computeMax(TreeNode node,long totalSum){
        if(node==null)return 0;

        long leftSubSum=computeMax(node.left,totalSum);
        long rightSubSum=computeMax(node.right,totalSum);
        long currSum=node.val+leftSubSum+rightSubSum;
        maxProductVal=Math.max(maxProductVal,currSum*(totalSum-currSum));
        return currSum;
    }
}