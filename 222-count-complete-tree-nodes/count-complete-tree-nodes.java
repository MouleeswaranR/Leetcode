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
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int leftHeight=countLeft(root);
        int rightHeight=countRight(root);
        if(leftHeight==rightHeight)return ((1<<leftHeight)-1);
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int countLeft(TreeNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.left;
        }
        return count;
    }
      public int countRight(TreeNode node){
        int count=0;
        while(node!=null){
            count++;
            node=node.right;
        }
        return count;
    }
}