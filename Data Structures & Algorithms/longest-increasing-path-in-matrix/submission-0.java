class Solution {
    int rows;
    int cols;
    int dp[][];
    int ans=0;
    int matrix[][];
    public int dfs( int i,int j,int val){
        if(i<0 || i>=rows|| j<0 || j>=cols || matrix[i][j]<=val)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res = 1;
        res=Math.max(1+dfs(i+1,j,matrix[i][j]),res);
        res=Math.max(1+dfs(i-1,j,matrix[i][j]),res);
        res=Math.max(1+dfs(i,j+1,matrix[i][j]),res);
        res=Math.max(1+dfs(i,j-1,matrix[i][j]),res);
        dp[i][j]=res;
        ans=Math.max(ans,dp[i][j]);
        return res;

    }
    public int longestIncreasingPath(int[][] matrix) {
        this.rows=matrix.length;
        this.cols=matrix[0].length;
        this.dp=new int[rows][cols];
        for(int i=0;i<rows;i++)
            Arrays.fill(dp[i],-1);
        this.matrix=matrix;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++){
                dfs(i,j,-1);
            }
        }
        return ans;
    }
}
