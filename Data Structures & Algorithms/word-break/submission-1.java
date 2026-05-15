class Solution {
    public boolean helper(String s, List<String> wordDict,int i,int[] dp){
        if(i==s.length())
            return true;
        if(dp[i]!=-1) return dp[i]==0?false:true;
        for(int idx=i;idx<s.length();idx++){
            for(String word:wordDict){
                if(s.substring(i,idx+1).equals(word)){
                    System.out.println(word);
                     if(helper(s,wordDict,idx+1,dp))
                     {  
                        dp[i]=1; 
                        return true;
                     }
                }
            }
        }
        dp[i]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,wordDict,0,dp);
    }
}
