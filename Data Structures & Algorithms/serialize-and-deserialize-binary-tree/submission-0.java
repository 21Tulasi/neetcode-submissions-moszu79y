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

public class Codec {
    String s="";
    TreeNode root=null;
    public void dfs1(TreeNode root){
        if(root==null) {s=s+'N'+','; return;}
        s=s+Integer.toString(root.val)+',';
        dfs1(root.left);
        dfs1(root.right);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      
        dfs1(root);
        System.out.println(s);
        return s;
        
    }

    public TreeNode dfs2(String[] s,int[] i){
        if(s[i[0]].equals("N")) {i[0]++; return null;}
        int val = Integer.parseInt(s[i[0]]);
        TreeNode root = new TreeNode(val);
        i[0]++;
        root.left=dfs2(s,i);
        root.right=dfs2(s,i);
        return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        int[] i = {0};
        return dfs2(s,i);
       
    }
}
