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
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder2(Integer.MAX_VALUE,preorder,new int[]{0});
    }

    public TreeNode bstFromPreorder2(int bound,int[] preorder,int[] ind){
        if(ind[0]==preorder.length||preorder[ind[0]]>bound)return null;
        TreeNode root=new TreeNode(preorder[ind[0]++]);
       root.left=bstFromPreorder2(root.val,preorder,ind);
         root.right=bstFromPreorder2(bound,preorder,ind);
        return root;
    }
}