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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode parent = null;
        TreeNode curr = root;
        
        while(curr!=null && curr.val!=key){
            parent=curr;
            if(curr.val>key)
                curr=curr.left;
            else if(curr.val<key)
                curr=curr.right;
        }
        if(curr==null)
            return root;
        else{
            if(curr.left==null){
                if(parent==null) return curr.right;
                if(parent.left==curr)
                    parent.left=curr.right;
                else
                    parent.right=curr.right;
            }
            else if(curr.right==null){
                if(parent == null) return curr.left;
                if(parent.right==curr)
                    parent.left=curr.left;
                else
                    parent.right=curr.left;
            }
            else{

                TreeNode minParent = curr;
                TreeNode min = curr.right;
                while(min.left!=null){
                    minParent=min;
                    min=min.left;
                }
                curr.val = min.val;
                if(minParent.left==min){
                    minParent.left=min.right;
                }
                else
                    minParent.right=min.right;
            }
        }
        return root;
        
    }
}