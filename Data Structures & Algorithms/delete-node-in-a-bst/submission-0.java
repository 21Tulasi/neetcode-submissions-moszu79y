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
     public int getMin(TreeNode root){
        TreeNode curr = root;
        while(curr.left!=null)
            curr=curr.left;
        return curr.val;
    }
    public TreeNode delete(TreeNode root,int key){
        if(root==null) return null;
        if(root.val<key)
            root.right = delete(root.right,key);
        else if(root.val>key)
           root.left = delete(root.left,key);
        else
        {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            root.val = getMin(root.right);
            root.right = delete(root.right,root.val);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
         return  delete(root,key);
    }
}