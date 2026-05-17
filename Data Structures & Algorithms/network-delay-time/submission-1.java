class Solution {
    class Pair{
        int dist;
        int dest;
        Pair(int dist,int dest){
            this.dist=dist;
            this.dest=dest;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans[]= new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist); 
        ans[k]=0;
        pq.offer(new Pair(0,k));
        HashMap<Integer,List<Pair>> hm =new HashMap<>();
        for(int i=0;i<times.length;i++){
            int s = times[i][0];
            int d = times[i][1];
            int c = times[i][2];
            Pair p = new Pair(c,d);
            hm.computeIfAbsent(s,key->new LinkedList<>()).add(p);
        }
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            List<Pair> l = hm.getOrDefault(curr.dest,new LinkedList<>());
            for(int i=0;i<l.size();i++){
                Pair p = l.get(i);
                int d = p.dest;
                int c = p.dist;
                if(curr.dist+c < ans[d]){            
                    ans[d]=curr.dist+c;
                    pq.offer(new Pair(ans[d],d));
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=1;i<ans.length;i++)
        {    
            if(ans[i]==Integer.MAX_VALUE) return -1;
            res=Math.max(ans[i],res);
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}
