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
    public TreeNode mapNode(TreeNode root,int start,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        TreeNode target=new TreeNode(-1);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val==start)target=curr;
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return target;
    }
    public int findMin(TreeNode target,Map<TreeNode,TreeNode> parent_track){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        vis.put(target,true);
        int time=0;
        while(!q.isEmpty()){
            int size=q.size();
            int fl=0;

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && vis.get(curr.left)==null){
                    fl=1;
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                 if(curr.right!=null && vis.get(curr.right)==null){
                    fl=1;
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(parent_track.get(curr)!=null && vis.get(parent_track.get(curr))==null){
                    fl=1;
                    q.offer(parent_track.get(curr));
                    vis.put(parent_track.get(curr),true);
                }
            }
            if(fl==1) time++;
        }
        return time;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        TreeNode target=mapNode(root,start,parent_track);
        int minInfectTime=findMin(target,parent_track);
        return minInfectTime;
    }

}