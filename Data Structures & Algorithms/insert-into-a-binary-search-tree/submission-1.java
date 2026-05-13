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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode curr = root;
        while(curr!=null){
            parent =curr;
            if(val>curr.val)
            {  curr=curr.right;
                if(curr==null)
                parent.right=new TreeNode(val);
            }
            else if(val<curr.val)
              {  curr=curr.left;     
                 if(curr==null)
                parent.left=new TreeNode(val);
            }  
        }
        return root==null?new TreeNode(val):root;
    }
}