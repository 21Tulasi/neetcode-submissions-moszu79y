class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       HashMap<Integer,List<int[]>> hm = new HashMap<>();
       for(int i=0;i<flights.length;i++){
            hm.computeIfAbsent(flights[i][0],key->new ArrayList<int[]>()).add(new int[]{flights[i][1],flights[i][2]});
       }
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b)->{
                if(a[2]!=b[2])
                    return a[2]-b[2];
                else if(a[1]!=b[1])
                    return a[1]-b[1];
                return a[0]-b[0];
            }
        );
        cost[src]=0;
        q.offer(new int[]{src,0,0});
        int s=0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int l=0;l<len;l++){
                int dest = q.peek()[0];
                int c = q.peek()[1];
                int stops = q.peek()[2];
                System.out.println(dest+" "+c+" "+stops);
                q.poll();
                List<int[]> neigh = hm.get(dest);
                if(neigh!=null)
                {
                    for(int i=0;i<neigh.size();i++){
                        if(cost[neigh.get(i)[0]]>c+neigh.get(i)[1]){
                            cost[neigh.get(i)[0]]=c+neigh.get(i)[1];
                            q.offer(new int[]{neigh.get(i)[0],cost[neigh.get(i)[0]],stops+1});
                        }
                    }
                }

            }
            s++;
            if(s==k+1)
                break;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
