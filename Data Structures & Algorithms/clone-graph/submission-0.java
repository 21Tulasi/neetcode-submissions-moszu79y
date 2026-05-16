/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        if(node==null) return null;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(!hm.containsKey(curr)){
                hm.put(curr,new Node(curr.val));
            }
            for(int i=0;i<curr.neighbors.size();i++){
                Node n = curr.neighbors.get(i);
                if(!hm.containsKey(n))
                 {   hm.put(n,new Node(n.val));
                    q.offer(n);
                }
                hm.get(curr).neighbors.add(hm.get(n));
                
            }
        }
        return hm.get(node);
    }
}