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
    public int solve(TreeNode root,int val){
        if(root==null)return 0;

        val=(2*val)+root.val;

        if(root.left==null && root.right==null){
            return val;
        }

        return solve(root.left,val)+solve(root.right,val);
    }
    public int sumRootToLeaf(TreeNode root) {
        return solve(root,0);
    }
}