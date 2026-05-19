class Solution {
    int parent[];
    int rank[];
    public int find(int n){
        int curr = n;
        while(parent[curr]!=curr){
            parent[curr]=parent[parent[curr]];
            curr=parent[curr];
        }
        return curr;
    }
    public int union(int n1,int n2){
        int par1 = find(n1);
        int par2 = find(n2);
        if(par1==par2)
            return 0;
        int r1 = rank[par1];
        int r2 = rank[par2];
        if(r1>=r2){
            parent[par2]=par1;
            rank[par1]+=rank[par2];
        }
        else{
            parent[par1]=par2;
            rank[par2]+=rank[par1];
        }
        return 1;

    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> edges = new ArrayList<>();
        this.parent = new int[n+1];
        this.rank = new int[n+1];
        Arrays.fill(rank,1);
        for(int i=1;i<=n;i++)
            parent[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }
        edges.sort((a,b)->Integer.compare(a[0],b[0]));
        int res=0;
        for(int[] edge:edges){
            if(union(edge[1],edge[2])==1)
                res+=edge[0];
        }
        return res;
        
        
    }
}
