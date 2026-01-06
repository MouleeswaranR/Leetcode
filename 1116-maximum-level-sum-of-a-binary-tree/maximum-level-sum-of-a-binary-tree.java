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
    public int maxLevelSum(TreeNode root) {
       int maxSum=Integer.MIN_VALUE;
       int currLevel=1;
       int maxLevel=-1;

       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);

       while(!q.isEmpty()){
        int n=q.size();
        int currSum=0;

        for(int i=0;i<n;i++){
            TreeNode curr=q.poll();
            currSum+=curr.val;

            if(curr.left!=null){
                q.offer(curr.left);
            }

            if(curr.right!=null){
                q.offer(curr.right);
            }
        }
        if(currSum>maxSum){
            maxSum=currSum;
            maxLevel=currLevel;
        }
        currLevel++;

       }
       return maxLevel;
    }

}