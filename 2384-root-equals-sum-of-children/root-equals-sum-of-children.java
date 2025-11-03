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
    public boolean checkTree(TreeNode root) {
        return solve(root);
    }

    public boolean solve(TreeNode node){
        if(node.left==null&&node.right==null){
            return true;
        }
        int left=node.left.val,right=node.right.val;
        if(node.val!=(left+right))return false;
        if(solve(node.left)==true)return true;
        if(solve(node.right)==true)return true;
        return false;
    }
}