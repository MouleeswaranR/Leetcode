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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||postorder==null||inorder.length!=postorder.length)return null;
        Map<Integer,Integer> inOrderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)inOrderMap.put(inorder[i],i);
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inOrderMap);
    }

    public TreeNode buildTree(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd,Map<Integer,Integer> map){
        if(inStart>inEnd||postStart>postEnd)return null;

        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(postorder[postEnd]);
        int numsLeft=inRoot-inStart;
        root.left=buildTree(inorder,inStart,inRoot-1,postorder,postStart,postStart+numsLeft-1,map);
        root.right=buildTree(inorder,inRoot+1,inEnd,postorder,postStart+numsLeft,postEnd-1,map);
        return root;
    }
}