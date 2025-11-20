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
class BSTIterator{
    private Stack<TreeNode> st;
    boolean reverse;

    public BSTIterator(TreeNode root,boolean reverse){
        st=new Stack<>();
        this.reverse=reverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next(){
        TreeNode temp=st.pop();
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }

    public void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            if(reverse==true){
                node=node.right;
            } else{
                node=node.left;
            }
        }
    }
} 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;

        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next(),j=r.next();

        while(i<j){
            if(i+j==k)return true;
            else if(i+j<k)i=l.next();
            else j=r.next();
        }
        return false;
    }
}