class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[0]=1;
        // dp[1]=1;
        for(int i=1;i<=s.length();i++){
            char c = s.charAt(i-1);
            if(c=='0')
                dp[i]=0;
            else{
            dp[i]=dp[i-1];}
            if(i-2>=0)
            {int val = Integer.parseInt(s.substring(i-2,i));
            if(val>=10 && val<=26)
                dp[i]+=dp[i-2];}

        }
        return dp[s.length()];
    }
}
