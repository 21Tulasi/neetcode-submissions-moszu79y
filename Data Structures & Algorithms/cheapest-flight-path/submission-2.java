class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
        int cost[] = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=k;i++){
            int[] tempCost = Arrays.copyOf(cost, n);
              for (int[] flight : flights) {
                int u = flight[0];
                   if(cost[u]==Integer.MAX_VALUE) continue;
                    int v = flight[1];
                    int wt = flight[2];
                    if(cost[u]+wt<tempCost[v])
                        tempCost[v]=cost[u]+wt;
                

            }
            cost= tempCost;
        }
        if(cost[dst]==Integer.MAX_VALUE) return -1;
        return cost[dst];
       
    }
}
