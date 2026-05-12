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
    class Pair{
        TreeNode node;
        int height;
        Pair(TreeNode node,int height){
            this.node=node;
            this.height=height;
        }
    }
    public int maxDepth(TreeNode root) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        int maxDepth =0;
        while(!st.isEmpty()){
            Pair curr = st.pop();
            if(curr.node!=null){
                maxDepth=Math.max(maxDepth,curr.height);
                st.push(new Pair(curr.node.left,curr.height+1));
                st.push(new Pair(curr.node.right,curr.height+1));
            }
        }
        return maxDepth;
    }
}
