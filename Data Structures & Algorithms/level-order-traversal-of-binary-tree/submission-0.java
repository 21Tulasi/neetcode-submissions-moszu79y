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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ll = new LinkedList<>();
        if(root==null) return ll;
        q.offer(root);
        while(q.size()>0){
            int len = q.size();
            List<Integer> l = new LinkedList<>();
            while(len>0){
                TreeNode curr = q.poll();
                if(curr!=null) l.add(curr.val);
                if(curr!=null && curr.left!=null)q.offer(curr.left);
                if(curr!=null && curr.right!=null)q.offer(curr.right);
                len--;
            }
            ll.add(l);

        }
        return ll;

    }
}
