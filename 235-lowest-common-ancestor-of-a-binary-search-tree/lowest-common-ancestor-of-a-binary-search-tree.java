/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minVal=Math.min(p.val,q.val),maxVal=Math.max(p.val,q.val);
        while(root!=null){
            if(root.val<minVal){
                root=root.right;
            }else if(root.val>maxVal){
                root=root.left;
            }else{
                break;
            }
        }
        return root;
    }
}