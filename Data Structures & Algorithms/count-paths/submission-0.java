class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
            dp[i]=1;
        for(int i=1;i<m;i++)
        {
            int[] currdp=new int[n];
            currdp[0]=1;
            for(int j=1;j<n;j++){
                currdp[j]=currdp[j-1]+dp[j];
            }
            dp=currdp;
        }
        return dp[n-1];
        
    }
}
