class Solution {
    Boolean dp[][];
    public boolean backTrack(String s1,String s2,String s3,int i,int j,int k){
        if(k==s3.length())
        {
            return (i==s1.length() && j==s2.length());
        }
        if(dp[i][j]!=null) return dp[i][j];
        boolean res=false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
            res=(backTrack(s1,s2,s3,i+1,j,k+1)) ;
        if(!res && j<s2.length() && s2.charAt(j)==s3.charAt(k))
            res=backTrack(s1,s2,s3,i,j+1,k+1);
        dp[i][j]=res;
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        this.dp = new Boolean[s1.length()+1][s2.length()+1];
        return backTrack(s1,s2,s3,0,0,0);
        
    }
}
