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

class Info {
    boolean isBST;
    int min;
    int max;
    int sum;

    Info(boolean isBST, int min, int max, int sum) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

class Solution {
    
    private Info largestBST(TreeNode root, int[] ans) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = largestBST(root.left, ans);
        Info right = largestBST(root.right, ans);

        if (left.isBST && right.isBST &&
            root.val > left.max && root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;
            ans[0] = Math.max(ans[0], currSum);

            return new Info(
                true,
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                currSum
            );
        }

   
        return new Info(
            false,
            Integer.MIN_VALUE,  
            Integer.MAX_VALUE,  
            0                   
        );
    }
    
    public int maxSumBST(TreeNode root) {
        int[] ans = new int[1];
        largestBST(root, ans);
        return ans[0];
    }
}
