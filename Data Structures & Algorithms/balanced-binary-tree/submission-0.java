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
    public int maxHeight (TreeNode root){
        if (root==null) return 0;
        return Math.max(maxHeight(root.left),maxHeight(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        HashMap<TreeNode,Integer> hm = new HashMap<>();
        hm.put(null,0);
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        if(root ==null) return true;
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            if(curr!=null && !hm.containsKey(curr.left)){
                st.push(curr.left);
            }
            else  if(curr!=null && !hm.containsKey(curr.right)){
                st.push(curr.right);
            }
            else{
                int left = hm.get(curr.left);
                int right = hm.get(curr.right);
                if(Math.abs(left-right)>1)
                    return false;
                hm.put(curr,Math.max(left,right)+1);
                st.pop();
            }

        }
        return true;
       
    }
}
