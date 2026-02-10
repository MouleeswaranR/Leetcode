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
    public void inOrder(TreeNode root,List<Integer> vec){
        if(root==null)return;

        inOrder(root.left,vec);
        vec.add(root.val);
        inOrder(root.right,vec);
    }
    public TreeNode construct(int left,int right,List<Integer> vec){
        if(left>right)return null;
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(vec.get(mid));
        node.left=construct(left,mid-1,vec);
        node.right=construct(mid+1,right,vec);
        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> vec=new ArrayList<>();
        inOrder(root,vec);
        return construct(0,vec.size()-1,vec);
    }
}