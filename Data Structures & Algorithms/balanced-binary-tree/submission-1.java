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
    public int[] helper(TreeNode root){
        if(root == null)
            return new int[]{0,1};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int balanced = (Math.abs(left[0]-right[0])<2 && left[1]==1 && right[1]==1)?1:0;
        int height = Math.max(left[0],right[0])+1;
        return new int[]{height,balanced};


    }
    public boolean isBalanced(TreeNode root) {
        return helper(root)[1]==0?false:true;
        
    }
}
