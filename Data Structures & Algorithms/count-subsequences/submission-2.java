class Solution {
 
    int dp[][];
    public int backTrack(String s,String t,char[] ans,int i,int j){
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=backTrack(s,t,ans,i+1,j);
        if(s.charAt(i)==t.charAt(j))
         res+=backTrack(s,t,ans,i+1,j+1);
        dp[i][j]=res;
        return res;
        
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i],-1);
        if(s.length()<t.length()) return 0;
        return backTrack(s,t,new char[t.length()],0,0);
        // return count;
    }
}


