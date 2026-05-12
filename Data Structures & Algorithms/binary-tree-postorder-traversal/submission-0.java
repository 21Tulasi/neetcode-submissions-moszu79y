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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        List<Integer> l = new ArrayList<>();
        st.push(root);
        visit.push(false);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            boolean visited = visit.pop();
            if(curr!=null)
            if(visited){
                l.add(curr.val);                  
            }
            else{
                st.push(curr);
                visit.push(true);
                st.push(curr.right);
                visit.push(false);
                st.push(curr.left);
                visit.push(false);
            }
           
        }
        return l;
    }
}



