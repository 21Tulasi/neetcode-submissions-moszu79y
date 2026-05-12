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
    public int diameterOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,int []> hm = new HashMap<>();
        hm.put(null,new int[]{0,0});
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        int ans=0;
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            if(curr!=null && !hm.containsKey(curr.left)){
                st.push(curr.left);
            }
            else if(curr!=null && !hm.containsKey(curr.right)){
                st.push(curr.right);
            }
            else{
                int left = hm.get(curr.left)[0];
                int right = hm.get(curr.right)[0];
                int diameter = Math.max(left+right,Math.max(hm.get(curr.right)[1],hm.get(curr.left)[1]));
                hm.put(curr,new int[]{Math.max(left,right)+1,diameter});
                st.pop();
            }
        }
        return hm.get(root)[1];
    }
}
