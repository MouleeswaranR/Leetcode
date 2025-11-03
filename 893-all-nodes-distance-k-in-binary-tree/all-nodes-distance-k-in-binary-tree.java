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
    public void track_parent(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent_track=new HashMap<>();
        track_parent(root,parent_track);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> track=new HashMap<>();
        q.offer(target);
        track.put(target,true);
        int curr_level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(curr_level==k)break;
            curr_level++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && track.get(curr.left)==null){
                    q.offer(curr.left);
                    track.put(curr.left,true);
                }
                if(curr.right!=null&&track.get(curr.right)==null){
                    q.offer(curr.right);
                    track.put(curr.right,true);
                }

                if(parent_track.get(curr)!=null && track.get(parent_track.get(curr))==null){
                    q.offer(parent_track.get(curr));
                    track.put(parent_track.get(curr),true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}