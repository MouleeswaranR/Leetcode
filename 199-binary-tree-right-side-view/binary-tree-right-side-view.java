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
//  class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> result=new ArrayList<>();
//         if(root==null){
//             return result;
//         }
//         Queue<TreeNode> queue=new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int levelSize=queue.size();
//             for(int i=0;i<levelSize;i++){
//                 TreeNode curr=queue.poll();
//                 if(i==levelSize-1){
//                     result.add(curr.val);
//                 }
//                 if(curr.left!=null){
//                     queue.add(curr.left);
//                 }
//                 if(curr.right!=null){
//                     queue.add(curr.right);
//                 }
//             }
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        solve(root,0,ans);
        return ans; 
    }
    public void solve(TreeNode node,int level,List<Integer> ans){
        if(node==null)return;
        if(ans.size()==level)ans.add(node.val);
        solve(node.right,level+1,ans);
        solve(node.left,level+1,ans);
    }
}