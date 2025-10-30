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
 class Tuple{
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node,int column,int row){
        this.node=node;
        this.vertical=column;
        this.level=row;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mpp=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tup=q.poll();
            TreeNode node=tup.node;
            int vertical=tup.vertical;
            int level=tup.level;

            if(!mpp.containsKey(vertical)){
                mpp.put(vertical,new TreeMap<>());
            }
            if(!mpp.get(vertical).containsKey(level)){
                mpp.get(vertical).put(level,new PriorityQueue<>());
            }
            mpp.get(vertical).get(level).offer(node.val);
            if(node.left!=null){
                q.offer(new Tuple(node.left,vertical-1,level+1));
            }
            if(node.right!=null){
                  q.offer(new Tuple(node.right,vertical+1,level+1));
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> verticals:mpp.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:verticals.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
               
            }
        }
        return ans;
    }
}