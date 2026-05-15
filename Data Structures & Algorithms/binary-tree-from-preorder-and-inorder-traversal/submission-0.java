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
    HashMap<Integer,Integer> in = new HashMap<>();
    int pre=0;
    public TreeNode dfs(int[] preorder,int[] inorder,int i,int j){
        if(i>j) return null;
        TreeNode root = new TreeNode(preorder[pre++]);
        int mid = in.get(root.val);
        root.left=dfs(preorder,inorder,i,mid-1);
        root.right=dfs(preorder,inorder,mid+1,j);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            in.put(inorder[i],i);
        return dfs(preorder,inorder,0,inorder.length-1);

    }
}
