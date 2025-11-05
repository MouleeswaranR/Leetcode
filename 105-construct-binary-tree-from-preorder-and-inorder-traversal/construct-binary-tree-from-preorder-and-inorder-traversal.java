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
    int preOrdIndex;
    Map<Integer,Integer> inOrderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrdIndex=0;
        inOrderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return arrayToTree(preorder,0,preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder,int left,int right){
        if(left>right) return null;
        int rootVal=preorder[preOrdIndex];
        preOrdIndex++;
        TreeNode root=new TreeNode(rootVal);
        root.left=arrayToTree(preorder,left,inOrderMap.get(rootVal)-1);
        root.right=arrayToTree(preorder,inOrderMap.get(rootVal)+1,right);
        return root;
    }
}