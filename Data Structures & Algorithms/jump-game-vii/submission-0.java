class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean dp[] = new boolean[s.length()];
        dp[0]=true;
        for(int i=0;i<s.length();i++){
            int start = i+minJump;
            int end = Math.min(s.length()-1,i+maxJump);
            for(int j=start;j<=end;j++){
                if(dp[i] && s.charAt(j)=='0')
                dp[j]=true;
            }
        }
        return dp[s.length()-1];
    }
}