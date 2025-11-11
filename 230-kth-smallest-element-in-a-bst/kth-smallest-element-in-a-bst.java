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
    public int kthSmallest(TreeNode root, int k) {
        int[] kSmallest=new int[]{Integer.MIN_VALUE};
        int[] count=new int[]{0};
        inorder(root,k,count,kSmallest);
        return kSmallest[0];
    }

    public void inorder(TreeNode node,int k,int[] count,int[] kSmallest){
        if(node==null||count[0]>=k)return;

        inorder(node.left,k,count,kSmallest);
        count[0]++;
        if(count[0]==k){
            kSmallest[0]=node.val;
            return;
        }
        inorder(node.right,k,count,kSmallest);
    }
}