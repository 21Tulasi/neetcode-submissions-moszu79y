class Solution {
    int[] parent;
    int[] rank;
    public int find(int node){
        int n = node;
        while(parent[n]!=n){
            parent[n]=parent[parent[n]];
            n=parent[n];
        }
        return n;
    }
    public int union(int n1,int n2){
        int par1 = find(n1);
        int par2 = find(n2);
        if(par1==par2)
            return 0;
        int rank1 = rank[par1];
        int rank2 = rank[par2];
        if(rank2>rank1){
            parent[par2]=par1;
            rank[par1]+=rank[par2];
        }
        else{
            parent[par1]=par2;
            rank[par2]+=rank[par1];
        }
        return 1;
    }
    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];
        int ans=n;
        for(int i=0;i<n;i++)
            parent[i]=i;
        this.rank= new int[n];
        Arrays.fill(rank,1);
        int[][] adj = new int[n][n];
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            int u = union(s,d);
            if(u==1)
                ans--;
        }
        return ans;
        
    }
}
