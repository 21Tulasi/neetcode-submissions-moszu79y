class Solution {
    int dp[][];
    public int backtrack(int amount,int[] coins,int i){
        if(i==coins.length){
            if(amount==0) return 1;
            else return 0;
        }
        if(dp[i][amount]!=-1)
            return dp[i][amount];
        int res =0;
        if(amount-coins[i]>=0)
            res=backtrack(amount-coins[i],coins,i);
        res+=backtrack(amount,coins,i+1);
        dp[i][amount]=res;
        return res;
    }
    public int change(int amount, int[] coins) {
        this.dp = new int[coins.length][amount+1]; 
        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-1);     
        return backtrack(amount,coins,0);
    }
}
