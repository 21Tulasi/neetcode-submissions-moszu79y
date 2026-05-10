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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l =  new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            int value=1000;
            for(int i=0;i<len;i++){
                if(q.peek()!=null)
                {    value = q.peek().val;
                     if(q.peek().left!=null)
                        q.offer(q.peek().left);
                     if(q.peek().right!=null)
                        q.offer(q.peek().right);
                }
                q.poll();
            }
            if(value!=1000)
            l.add(value);
        }
        return l;
        
    }
}
